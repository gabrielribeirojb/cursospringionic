package com.webigode.cursospringionic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webigode.cursospringionic.domain.Estado;
import com.webigode.cursospringionic.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;
	
	public List<Estado> findAll(){
		return repository.findAllByOrderByName();
	}
	
}
