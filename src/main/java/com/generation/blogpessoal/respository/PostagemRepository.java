package com.generation.blogpessoal.respository;

import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JpaRepository do Spring Data JPA

import com.generation.blogpessoal.model.Postagem; // Importa a classe Postagem do modelo

public interface PostagemRepository extends JpaRepository<Postagem, Long> { 


}
