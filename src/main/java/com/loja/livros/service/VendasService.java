package com.loja.livros.service;

import com.loja.livros.dto.VendaLivrosDTO;
import com.loja.livros.dto.VendasDTO;
import com.loja.livros.model.LivrosEntity;
import com.loja.livros.model.VendaLivrosEntity;
import com.loja.livros.model.VendasEntity;
import com.loja.livros.repository.LivrosRepository;
import com.loja.livros.repository.VendasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendasService {
    @Autowired
    private VendasRepository vendasRepository;

    @Autowired
    private LivrosService livrosService;

    @Autowired
    private LivrosRepository livrosRepository;

    @Autowired
    private VendaLivrosService vendaLivrosService;

    // Listar todas as vendas
    public List<VendasEntity> listarTodos() {
        return vendasRepository.findAll();
    }

    //Buscar uma venda por ID
    public VendasEntity buscarPorId(Long id) {
        return vendasRepository.findById(id).orElse(null);
    }

    // Salvar nova venda com cálculo automático do valor total
    public VendasEntity salvar(VendasDTO dto) {
        VendasEntity venda = new VendasEntity();
        venda.setDataVenda(dto.getDataVenda());

        BigDecimal valorTotal = BigDecimal.ZERO;

        for (VendaLivrosDTO item : dto.getItens()) {
            LivrosEntity livro = livrosRepository.findById(item.getIdLivro()).orElseThrow(() ->
                    new RuntimeException("Livro não encontrado"));
            // Multiplica valor unitário pela quantidade vendida
            BigDecimal subtotal = livro.getVlrUnitario().multiply(BigDecimal.valueOf(item.getQtd()));
            //soma ao total da venda
            valorTotal = valorTotal.add(subtotal);
        }
        venda.setValorTotal(valorTotal);
        vendasRepository.save(venda);

        for (VendaLivrosDTO item : dto.getItens()) {
            item.setIdVenda(venda.getId());
            item.setIdLivro(item.getIdLivro());
            item.setQtd(item.getQtd());
            System.out.println("Item salvo: " + item);
            vendaLivrosService.salvar(item);
        }
        return venda;
    }

    //atualizar uma venda existente
    @Transactional
    public VendasEntity atualizar(Long id, VendasDTO dto) {
        VendasEntity venda = vendasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));

        // Atualiza os dados principais da venda
        venda.setDataVenda(dto.getDataVenda());
        venda.setValorTotal(dto.getValorTotal());

        vendasRepository.save(venda);

        // Remove os itens antigos
        vendaLivrosService.deletarPorIdVenda(id);

        for (VendaLivrosDTO item : dto.getItens()) {
            item.setIdVenda(id);
            item.setIdLivro(item.getIdLivro());
            item.setQtd(item.getQtd());
            System.out.println("Item salvo: " + item);
            vendaLivrosService.salvar(item);
        }

        return venda;
    }


    //deletar uma venda
    public void deletar(Long id){
        vendaLivrosService.deletarPorIdVenda(id);
        vendasRepository.deleteById(id);
    }

}
