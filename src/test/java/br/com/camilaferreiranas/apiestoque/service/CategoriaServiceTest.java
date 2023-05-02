package br.com.camilaferreiranas.apiestoque.service;

import br.com.camilaferreiranas.apiestoque.dto.CategoriaDto;
import br.com.camilaferreiranas.apiestoque.model.Categoria;
import br.com.camilaferreiranas.apiestoque.repositories.CategoriaRepository;
import br.com.camilaferreiranas.apiestoque.services.CategoriaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {

    @Mock
    CategoriaRepository categoriaRepository;

    @InjectMocks
    CategoriaService categoriaService;

    @Test
    public void testFindAllCategorias() {
        List<Categoria> listaCategorias = new ArrayList<>();
        Categoria categoria1 = new Categoria();
        Categoria categoria2 = new Categoria();
        categoria1.setId(1L);
        categoria1.setDescricao("Decoração");
        categoria2.setId(2L);
        categoria2.setDescricao("Computadores");
        listaCategorias.add(categoria1);
        listaCategorias.add(categoria2);
        Mockito.when(categoriaRepository.findAll()).thenReturn(listaCategorias);
        List<Categoria> categorias = categoriaService.getAllCategorias();
        Assertions.assertEquals(listaCategorias, categorias);
    }

    @Test
    public void salvarNovaCategoria() {
        Categoria categoria = new Categoria();
        CategoriaDto dto = new CategoriaDto();
        dto.setDescricao("Decoração");
        categoria.setDescricao(dto.getDescricao());
        Mockito.when(categoriaRepository.save(categoria)).thenReturn(categoria);
        Categoria categoria1 = categoriaService.salvarCategoria(dto);
        Assertions.assertEquals(categoria.getDescricao(), categoria1.getDescricao());
    }

    @Test
    public void buscarCategoriaPelaDescricao() {
        Categoria categoria = new Categoria();
        categoria.setDescricao("Decoração");
        Mockito.when(categoriaRepository.findCategoriaByDescricao("Decoração")).thenReturn(Optional.of(categoria));
        Optional<Categoria> categoria1 = categoriaService.getCategoriaByDescricao("Decoração");
        Assertions.assertEquals(categoria1.map(Categoria::getDescricao), Optional.of(categoria.getDescricao()));
    }

}
