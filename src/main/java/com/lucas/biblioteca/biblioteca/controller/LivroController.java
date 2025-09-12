package com.lucas.biblioteca.biblioteca.controller;

import com.lucas.biblioteca.biblioteca.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.lucas.biblioteca.biblioteca.model.Livro;
import org.springframework.http.HttpStatus;



@RestController
@RequestMapping("/livros")
public class LivroController{

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> criar(@RequestBody Livro livro){
        Livro salvo = livroService.salvar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar(){
        return ResponseEntity.ok(livroService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id){
        return livroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livro){
        Livro atualizado = livroService.atualizar(id, livro);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
