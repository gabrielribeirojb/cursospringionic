package com.webigode.cursospringionic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webigode.cursospringionic.domain.Cidade;
import com.webigode.cursospringionic.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> findByEstado(Integer estadoId){
		return repository.findCidades(estadoId);
	}
	
}
