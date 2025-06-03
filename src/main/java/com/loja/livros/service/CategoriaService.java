package com.loja.livros.service;

import com.loja.livros.dto.CategoriaDTO;
import com.loja.livros.model.Categoria;
import com.loja.livros.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // Informa ao Spring que essa classe é um componente de serviço
public class CategoriaService {
    //Injeta automaticamente o repositório para acesso ao banco de dados
    @Autowired
    private CategoriaRepository categoriaRepository;

    //Metodo para listar todas as categoria do banco
    public List<CategoriaDTO> listarTodos() {
        //Pede pro repositório trazer tudo, transforma cada um em DTO e devolve
        return categoriaRepository.findAll().stream()
                .map(this::toDTO) // converter de Categoria -> CategoriaDTO
                .collect(Collectors.toList());
    }
    // Metodo para salvar uma nova categoria
    public CategoriaDTO salvar(CategoriaDTO dto) {
        // Cria uma nova caixinha Categoria e coloca o nome que veio do DTO
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        Categoria salvo = categoriaRepository.save(categoria);
        return toDTO(salvo);
    }

    //Metodo para atualizar uma categoria existente
    public CategoriaDTO atualizar(Integer id, CategoriaDTO dto){
        // Procura a categoria com o ID, se não achar, dá erro
        Categoria categoria= categoriaRepository.findById(id).orElseThrow();

        // Atualiza o nome dela com o que veio no DTO
        categoria.setNome(dto.getNome());

        //Salva de novo no Banco (atualiza)
        Categoria atualizado = categoriaRepository.save(categoria);
    // Transforma em DTO para devolver
        return toDTO(atualizado);
    }
    //metodo para buscar uma categoria pelo numero id
    public CategoriaDTO buscarPorId(Integer id) {
        //Se encontrar, transforma em DTO. Se não, devolve null.
        return categoriaRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }
    //metodo para apagar uma categoria
    public void deletar(Integer id) {
        //apaga a categoria com esse numero do banco
        categoriaRepository.deleteById(id);
    }
    //metodo privado que transformou uma categoria (do banco)
    // em CategoriaDTO (Para mostrar bonitinho)
    private CategoriaDTO toDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());

        return dto;
    }

}

