package com.loja.livros.service;

import com.loja.livros.dto.AutorDTO;
import com.loja.livros.model.Autor;
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

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor salvar(AutorDTO dto) {
        Autor autor = new Autor();
        autor.setNome(dto.getNome());
        Autor salvo = autorRepository.save(autor);
        return salvo;
    }

    public Autor atualizar (Integer id, AutorDTO dto) {
        Autor autor = autorRepository.findById(id).orElse(null);

        if (autor != null) {
            autor.setNome(dto.getNome());
            return autorRepository.save(autor);
        }
        return null;
    }

    public void deletar(Integer id) {
        autorRepository.deleteById(id);
    }

    public Autor buscarPorId(Integer id) {
        return autorRepository.findById(id).orElse(null);
    }
}
