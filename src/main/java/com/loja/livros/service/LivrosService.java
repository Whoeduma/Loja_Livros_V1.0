package com.loja.livros.service;

import com.loja.livros.dto.LivrosDTO;
import com.loja.livros.model.Livros;
import com.loja.livros.repository.AutorRepository;
import com.loja.livros.repository.CategoriaRepository;
import com.loja.livros.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivrosService {
    @Autowired
    private LivrosRepository livrosRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    //Lista todos os livros convertidos para DTO

    public List<Livros> listarTodos() {
        return livrosRepository.findAll();
    }

    //Salva um novo livro no banco de dados
    //Recebe um DTO e converte para entidade

    public LivrosDTO salvar(LivrosDTO dto) {
        Livros livro = toEntity(dto);
        Livros salvo= livrosRepository.save(livro);
        return toDTO(salvo);
    }

    //Atualiza um livro existente com base no ID.
    public LivrosDTO atualizar(Integer id, LivrosDTO dto) {
        Livros livro = livrosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + id));

        livro.setNome(dto.getNome());
        livro.setPreco(dto.getPreco());

        livro.setAutor(autorRepository.findById(dto.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com ID: " + dto.getAutorId())));

        livro.setCategoria(categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + dto.getCategoriaId())));

        Livros atualizado = livrosRepository.save(livro);
        return toDTO(atualizado);
    }

    //Busca um livro pelo ID e retorna como DTO.
    public Livros buscarPorId(Integer id) {
        return livrosRepository.findById(id).orElse(null);
    }

    //Deleta um livro com base no ID.
    public void deletar(Integer id) {
        livrosRepository.deleteById(id);
    }

    //converte uma entidade livros para livrosDTO
    private LivrosDTO toDTO(Livros livro) {
        LivrosDTO dto = new LivrosDTO();
        dto.setId(livro.getId());
        dto.setNome(livro.getNome());
        dto.setPreco(livro.getPreco());
        dto.setAutorId(livro.getAutor().getId());
        dto.setCategoriaId(livro.getCategoria().getId());
        return dto;
    }

    //Converte um DTO para entidade livros
    private Livros toEntity(LivrosDTO dto) {
        Livros livro = new Livros();
        livro.setId(dto.getId());
        livro.setNome(dto.getNome());
        livro.setPreco(dto.getPreco());
        livro.setAutor(autorRepository.findById(dto.getAutorId()).orElse(null));
        livro.setCategoria(categoriaRepository.findById(dto.getCategoriaId()).orElse(null));
        return livro;
    }

    public Livros buscarEntidadePorId(Integer id) {
        return livrosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livros com ID" + id + "não encontrado"));
    }

}
