package com.webigode.cursospringionic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webigode.cursospringionic.domain.Pedido;
import com.webigode.cursospringionic.repositories.PedidoRepository;
import com.webigode.cursospringionic.service.excetions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public Pedido findById(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
}
