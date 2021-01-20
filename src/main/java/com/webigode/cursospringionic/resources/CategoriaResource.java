package com.webigode.cursospringionic.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webigode.cursospringionic.domain.Categoria;

@RestController
@RequestMapping(value="categorias")
public class CategoriaResource {
	
	@GetMapping
	public List<Categoria> listar() {
		List<Categoria> list = new ArrayList<>();
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		list.addAll(Arrays.asList(cat1,cat2));
		
		return list;
	}
}
