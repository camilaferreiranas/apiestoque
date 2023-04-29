package br.com.camilaferreiranas.apiestoque.services;

import br.com.camilaferreiranas.apiestoque.dto.CategoriaDto;
import br.com.camilaferreiranas.apiestoque.model.Categoria;
import br.com.camilaferreiranas.apiestoque.repositories.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria salvarCategoria(CategoriaDto dto) {
        Categoria categoria = new Categoria();
        categoria.setDescricao(dto.getDescricao());
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> getCategoriaByDescricao(String descricao) {
        return categoriaRepository.findCategoriaByDescricao(descricao);
    }
}
