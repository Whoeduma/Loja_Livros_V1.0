package com.loja.livros.controller;

import com.loja.livros.dto.AutorDTO;
import com.loja.livros.model.Autor;
import com.loja.livros.service.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/autores")
public class AutorController {
    private final AutorService autorService;
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/listar")
    public List<Autor> listarTodos() {
        return autorService.listarTodos();
    }



    @PostMapping("/salvar")
    public Autor salvar(@RequestBody AutorDTO autor) {
        return autorService.salvar(autor);
    }

    @GetMapping("/buscar/{id}")
    public Autor buscarPorId(@PathVariable Integer id) {
        return autorService.buscarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public Autor atualizar(@PathVariable Integer id, @RequestBody AutorDTO autor) {
        return autorService.atualizar(id, autor);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar (@PathVariable Integer id) {
        autorService.deletar(id);
    }
}
