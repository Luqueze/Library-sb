package com.lucas.biblioteca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lucas.biblioteca.biblioteca.model.Livro;
import org.springframework.stereotype.Repository;


@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
