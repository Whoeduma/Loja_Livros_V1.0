package com.loja.livros.service;

import com.loja.livros.model.Livros;
import com.loja.livros.model.Vendas;
import com.loja.livros.repository.LivrosRepository;
import com.loja.livros.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendasService {
    @Autowired
    private VendasRepository vendasRepository;

    @Autowired
    private LivrosService livrosService;

    @Autowired
    private LivrosRepository livrosRepository;

    // Listar todas as vendas
    public List<Vendas> listarTodos() {
        return vendasRepository.findAll();
    }

    //Buscar uma venda por ID
    public Vendas buscarPorId(Integer id) {
        return vendasRepository.findById(id).orElse(null);
    }

    // Salvar nova venda com cálculo automático do valor total
    public Vendas salvar(Vendas venda) {
        Livros livro = livrosRepository.findById(venda.getLivro().getId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + venda.getLivro().getId()));
        Double precoUnitario = livro.getPreco();
        Integer quantidade = venda.getQtd();
        Double precoTotal = precoUnitario * quantidade;

        venda.setLivro(livro); // garante que o objeto esteja populado corretamente
        venda.setPrecoTotal(precoTotal);

        return vendasRepository.save(venda);
    }

    //atualizar uma venda existente
    public Vendas atualizar(Integer id, Vendas novaVenda) {
        Vendas vendaExistente = vendasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada com ID: " + id));

        Livros livro = livrosRepository.findById(novaVenda.getLivro().getId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID:" + novaVenda.getLivro().getId()));

        vendaExistente.setLivro(livro);
        vendaExistente.setQtd(novaVenda.getQtd());
        vendaExistente.setDataVenda(novaVenda.getDataVenda());
        // Recalcula o preço total com base no novo livro e nova quantidade
        vendaExistente.setPrecoTotal(livro.getPreco() * novaVenda.getQtd());

        return vendasRepository.save(vendaExistente);

    }

    //deletar uma venda
    public void deletar(Integer id){
        vendasRepository.deleteById(id);
    }

}
