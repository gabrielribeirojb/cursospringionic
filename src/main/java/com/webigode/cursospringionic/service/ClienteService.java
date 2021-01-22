package com.webigode.cursospringionic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webigode.cursospringionic.domain.Cliente;
import com.webigode.cursospringionic.repositories.ClienteRepository;
import com.webigode.cursospringionic.service.excetions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
}
