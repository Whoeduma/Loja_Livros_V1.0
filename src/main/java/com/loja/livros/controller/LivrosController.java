package com.loja.livros.controller;

import com.loja.livros.dto.LivrosDTO;
import com.loja.livros.model.LivrosEntity;
import com.loja.livros.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController//Indica que esta classe trata requisicoes REST(API)
@RequestMapping("/api/livros")//todos os endpoints aqui comecam com /api/livros
@CrossOrigin(origins = "*") //permite chamadas de outros dominios  (como o frontend Angular ou React)
public class LivrosController {
    @Autowired
    private LivrosService livrosService;

    //GET/livros ➜ Lista todos os livros
    @GetMapping("/listar")
    public List<LivrosEntity> listarTodos() {
        return livrosService.listarTodos();
    }

    //GET /livros/{id} ➜ Busca um livro por ID
    @GetMapping("/buscar/{id}")
    public LivrosEntity buscarPorId(@PathVariable Long id) {
        return livrosService.buscarPorId(id);
    }

    //POST /livros ➜ Cadastra um novo livro
    @PostMapping("/salvar")
    public LivrosDTO salvar(@RequestBody LivrosDTO dto) {
        return livrosService.salvar(dto);
    }

    //PUT /livros/{id} ➜ Atualiza um livro
    @PutMapping("/atualizar/{id}")
    public LivrosDTO atualizar(@PathVariable Long id, @RequestBody LivrosDTO dto){
        return livrosService.atualizar(id, dto);
    }

    // DELETE /livros/{id} ➜ Deleta um livro
    @DeleteMapping("/deletar/{id}")
        public void deletar(@PathVariable Long id) {
            livrosService.deletar(id);
    }


}
