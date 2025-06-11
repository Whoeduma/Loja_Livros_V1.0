package com.loja.livros.service;

import com.loja.livros.dto.AutorDTO;
import com.loja.livros.model.AutorEntity;
import com.loja.livros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    private  AutorRepository autorRepository;

   // public AutorService(AutorRepository autorRepository) {
      //  this.autorRepository = autorRepository;
   // }

    public List<AutorEntity> listarTodos() {
        return autorRepository.findAll();
    }

    public AutorEntity salvar(AutorDTO dto) {
        AutorEntity autor = new AutorEntity();
        autor.setNome(dto.getNome());
        AutorEntity salvo = autorRepository.save(autor);
        return salvo;
    }

    public AutorEntity atualizar (Long id, AutorDTO dto) {
        AutorEntity autor = autorRepository.findById(id).orElse(null);
        if (autor != null) {
            autor.setNome(dto.getNome());
            return autorRepository.save(autor);
        }
        return null;
    }

    public void deletar(Long id) {
        autorRepository.deleteById(id);
    }

    public AutorEntity buscarPorId(Long id) {
        return autorRepository.findById(id).orElse(null);
    }
}
