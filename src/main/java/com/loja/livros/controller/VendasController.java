package com.loja.livros.controller;


import com.loja.livros.dto.VendasDTO;
import com.loja.livros.model.VendasEntity;
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
    public VendasEntity salvar (@RequestBody VendasDTO venda) {
        return vendasService.salvar(venda);
    }

    // GET /api/vendas ➜ Lista todas as vendas
    @GetMapping("/listar")
    public List<VendasEntity> listarTodos() {
        return vendasService.listarTodos();
    }

    //GET /api/vendas/{id} ➜ Busca venda por ID
    @GetMapping("/buscar/{id}")
    public VendasEntity buscarPorId(@PathVariable Long id) {
        return vendasService.buscarPorId(id);
    }

    //PUT /api/atualizar/{id} ➜ Atualiza venda por ID
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<VendasEntity> atualizar(@PathVariable Long id, @RequestBody VendasDTO dto) {
        VendasEntity vendaAtualizada = vendasService.atualizar(id, dto);
        return ResponseEntity.ok(vendaAtualizada);
    }

    // DELETE /api/vendas/{id} ➜ Deleta uma venda
    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        vendasService.deletar(id);
    }
}
