package br.com.camilaferreiranas.apiestoque.service;

import br.com.camilaferreiranas.apiestoque.repositories.CategoriaRepository;
import br.com.camilaferreiranas.apiestoque.services.CategoriaService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {

    @Mock
    CategoriaRepository categoriaRepository;

    @InjectMocks
    CategoriaService categoriaService;
}
