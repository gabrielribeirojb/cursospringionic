package com.webigode.cursospringionic.service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webigode.cursospringionic.domain.ItemPedido;
import com.webigode.cursospringionic.domain.PagamentoComBoleto;
import com.webigode.cursospringionic.domain.Pedido;
import com.webigode.cursospringionic.domain.enums.EstadoPagamento;
import com.webigode.cursospringionic.repositories.ItemPedidoRepository;
import com.webigode.cursospringionic.repositories.PagamentoRepository;
import com.webigode.cursospringionic.repositories.PedidoRepository;
import com.webigode.cursospringionic.service.excetions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public Pedido findById(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(Date.from(Instant.now()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repository.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		
		for(ItemPedido item : obj.getItens()) {
			item.setDesconto(0.0);
			item.setPreco(produtoService.findById(item.getProduto().getId()).getPreco());
			item.setPedido(obj);
		}
		
		itemPedidoRepository.saveAll(obj.getItens());
		
		return obj;
	}
}
