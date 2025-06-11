package com.loja.livros.controller;

import com.loja.livros.dto.CategoriaDTO;
import com.loja.livros.model.CategoriaEntity;
import com.loja.livros.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Toda vez que alguém acessar /api/categorias na internet, vem pra cá
@RequestMapping("/api/categorias")

//Permite que qualquer lugar (por exemplo, o frontend) consiga conversar com essa classe
@CrossOrigin(origins = "*")

public class CategoriaController {
    // Aqui chamamos nosso ajudante que sabe tudo sobre categoria
    @Autowired
    private CategoriaService categoriaService;

    //Quando alguém bater na porta GET /categorias, a gente mostra todas as categorias
    @GetMapping("/listar")
    public List<CategoriaEntity> listarTodos() {
        return categoriaService.listarTodos();
    }

    //Quando alguém enviar uma nova categoria pelo POST /categorias, a gente salva
    @PostMapping("/salvar")
    public CategoriaDTO salvar(@RequestBody CategoriaDTO dto) {
        return categoriaService.salvar(dto);
    }

    //Quando alguém quiser atualizar uma categoria, usa PUT /categorias/1 (por exemplo)
    @PutMapping("/atualizar/{id}")
    public CategoriaDTO atualizar(@PathVariable Long id, @RequestBody CategoriaDTO dto){
        return categoriaService.atualizar(id,dto);
    }

    //Quando alguém quiser ver uma categoria específica, GET /categorias/1
    @GetMapping("/buscar/{id}")
    public CategoriaDTO buscarPorId(@PathVariable Long id) {
        return categoriaService.buscarPorId(id);
    }

    //Quando alguém quiser apagar uma categoria, usa DELETE /categorias/1
    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
    }


}
