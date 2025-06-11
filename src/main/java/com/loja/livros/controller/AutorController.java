package com.loja.livros.controller;

import com.loja.livros.dto.AutorDTO;
import com.loja.livros.model.AutorEntity;
import com.loja.livros.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/listar")
    public List<AutorEntity> listarTodos() {
        return autorService.listarTodos();
    }

    @PostMapping("/salvar")
    public AutorEntity salvar(@RequestBody AutorDTO autor) {
        return autorService.salvar(autor);
    }

    @GetMapping("/buscar/{id}")
    public AutorEntity buscarPorId(@PathVariable Long id) {
        return autorService.buscarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public AutorEntity atualizar(@PathVariable Long id, @RequestBody AutorDTO autor) {
        return autorService.atualizar(id, autor);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar (@PathVariable Long id) {
        autorService.deletar(id);
    }
}
