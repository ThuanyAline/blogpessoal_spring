package com.generation.blogpessoal.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.blogpessoal.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {

	
public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao); // Método para buscar temas pela descrição, ignorando maiúsculas e minúsculas
}
