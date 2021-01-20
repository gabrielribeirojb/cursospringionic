package com.webigode.cursospringionic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webigode.cursospringionic.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
