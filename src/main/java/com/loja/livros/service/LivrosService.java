package com.loja.livros.service;

import com.loja.livros.dto.LivrosDTO;
import com.loja.livros.model.LivrosEntity;
import com.loja.livros.repository.AutorRepository;
import com.loja.livros.repository.CategoriaRepository;
import com.loja.livros.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivrosService {
    @Autowired
    private LivrosRepository livrosRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    //Lista todos os livros convertidos para DTO

    public List<LivrosEntity> listarTodos() {

        return livrosRepository.findAll();
    }

    //Salva um novo livro no banco de dados
    //Recebe um DTO e converte para entidade

    public LivrosDTO salvar(LivrosDTO dto) {
        LivrosEntity livro = toEntity(dto);
        LivrosEntity salvo= livrosRepository.save(livro);
        return toDTO(salvo);
    }

    //Atualiza um livro existente com base no ID.
    public LivrosDTO atualizar(Long id, LivrosDTO dto) {
        LivrosEntity livro = livrosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + id));

        livro.setNome(dto.getNome());
        livro.setVlrUnitario(dto.getVlrUnitario());

        livro.setAutor(autorRepository.findById(dto.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com ID: " + dto.getAutorId())));

        livro.setCategoriaEntity(categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + dto.getCategoriaId())));

        LivrosEntity atualizado = livrosRepository.save(livro);
        return toDTO(atualizado);
    }

    //Busca um livro pelo ID e retorna como DTO.
    public LivrosEntity buscarPorId(Long id) {
        return livrosRepository.findById(id).orElse(null);
    }

    //Deleta um livro com base no ID.
    public void deletar(Long id) {
        livrosRepository.deleteById(id);
    }

    //converte uma entidade livros para livrosDTO
    private LivrosDTO toDTO(LivrosEntity livro) {
        LivrosDTO dto = new LivrosDTO();
        dto.setId(livro.getId());
        dto.setNome(livro.getNome());
        dto.setVlrUnitario(livro.getVlrUnitario());
        dto.setAutorId(livro.getAutor().getId());
        dto.setCategoriaId(livro.getCategoriaEntity().getId());
        return dto;
    }

    //Converte um DTO para entidade livros
    private LivrosEntity toEntity(LivrosDTO dto) {
        LivrosEntity livro = new LivrosEntity();
        livro.setId(dto.getId());
        livro.setNome(dto.getNome());
        livro.setVlrUnitario(dto.getVlrUnitario());
        livro.setAutor(autorRepository.findById(dto.getAutorId()).orElse(null));
        livro.setCategoriaEntity(categoriaRepository.findById(dto.getCategoriaId()).orElse(null));
        return livro;
    }

    public LivrosEntity buscarEntidadePorId(Long id) {
        return livrosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livros com ID" + id + "não encontrado"));
    }

}
