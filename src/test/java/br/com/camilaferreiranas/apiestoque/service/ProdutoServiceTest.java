package br.com.camilaferreiranas.apiestoque.service;

import br.com.camilaferreiranas.apiestoque.model.Categoria;
import br.com.camilaferreiranas.apiestoque.model.Produto;
import br.com.camilaferreiranas.apiestoque.repositories.ProdutoRepository;
import br.com.camilaferreiranas.apiestoque.services.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @Mock
    ProdutoRepository produtoRepository;

    @InjectMocks
    ProdutoService produtoService;

    @Test
    void testFindAllProdutos() {
        List<Produto> expectedProdutos = new ArrayList<>();
        Produto p1 = new Produto();
        Categoria c1 = new Categoria();
        c1.setId(1L);
        c1.setDescricao("Categoria Teste");
        p1.setTitulo("Produto 1");
        p1.setDescricao("Descrição do produto 1");
        p1.setValorUnitario(10.0);
        p1.setCategoria(c1);
        expectedProdutos.add(p1);

        when(produtoRepository.findAll()).thenReturn(expectedProdutos);

        List<Produto> actualProdutos = produtoService.findAllProdutos();

        assertEquals(expectedProdutos, actualProdutos);
    }

}
