package com.loja.livros.controller;


import com.loja.livros.model.Vendas;
import com.loja.livros.service.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/vendas")
@CrossOrigin(origins = "*")
public class VendasController {
    @Autowired
    private VendasService vendasService;

    // POST /api/vendas/salvar ➜ Cadastra uma nova venda
    @PostMapping("/salvar")
    public Vendas salvar (@RequestBody Vendas venda) {
        return vendasService.salvar(venda);
    }

    // GET /api/vendas ➜ Lista todas as vendas
    @GetMapping("/listar")
    public List<Vendas> listarTodos() {
        return vendasService.listarTodos();
    }

    //GET /api/vendas/{id} ➜ Busca venda por ID
    @GetMapping("/buscar/{id}")
    public Vendas buscarPorId(@PathVariable Integer id) {
        return vendasService.buscarPorId(id);
    }

    //PUT /api/atualizar/{id} ➜ Atualiza venda por ID
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Vendas> atualizar(@PathVariable Integer id, @RequestBody Vendas venda) {
        Vendas atualizada = vendasService.atualizar(id, venda);
        return ResponseEntity.ok(atualizada);
    }

    // DELETE /api/vendas/{id} ➜ Deleta uma venda
    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Integer id) {
        vendasService.deletar(id);
    }
}
