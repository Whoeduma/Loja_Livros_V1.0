package com.loja.livros.service;

import com.loja.livros.dto.VendaLivrosDTO;
import com.loja.livros.model.LivrosEntity;
import com.loja.livros.model.VendaLivrosEntity;
import com.loja.livros.model.VendasEntity;
import com.loja.livros.repository.LivrosRepository;
import com.loja.livros.repository.VendaLivrosRepository;
import com.loja.livros.repository.VendasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaLivrosService {
    @Autowired
    private VendaLivrosRepository vendaLivrosRepository;

    @Autowired
    private LivrosRepository livrosRepository;

    @Autowired
    private VendasRepository vendasRepository;

   public VendaLivrosEntity salvar(VendaLivrosDTO dto) {
       VendasEntity venda = vendasRepository.findById(dto.getIdVenda()).orElseThrow(() ->
               new RuntimeException("Venda não encontrada"));

       LivrosEntity livro = livrosRepository.findById(dto.getIdLivro()).orElseThrow(() ->
               new RuntimeException("Livro não encontrado"));

       VendaLivrosEntity entity = new VendaLivrosEntity();
       entity.setVenda(venda);
       entity.setLivro(livro);
       entity.setQtd(dto.getQtd());

       return vendaLivrosRepository.save(entity);

   }

   @Transactional
   public void deletarPorIdVenda(Long idVenda) {
        vendaLivrosRepository.deleteByVendaId(idVenda);

   }
}
