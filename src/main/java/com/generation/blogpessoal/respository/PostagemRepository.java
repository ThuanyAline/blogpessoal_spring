package com.generation.blogpessoal.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JpaRepository do Spring Data JPA
import org.springframework.web.bind.annotation.GetMapping;

import com.generation.blogpessoal.model.Postagem; // Importa a classe Postagem do modelo

public interface PostagemRepository extends JpaRepository<Postagem, Long> { 

	@GetMapping
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo); // Método para buscar postagens pelo título, ignorando maiúsculas e minúsculas


 // SELECT * FROM tb_postagens WHERE titulo LIKE "%?%";
}
