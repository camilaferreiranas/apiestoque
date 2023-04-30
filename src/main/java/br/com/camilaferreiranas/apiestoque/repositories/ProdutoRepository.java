package br.com.camilaferreiranas.apiestoque.repositories;

import br.com.camilaferreiranas.apiestoque.model.Categoria;
import br.com.camilaferreiranas.apiestoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<List<Produto>> findProdutoByValorUnitario(Double valorUnitario);
    Optional<List<Produto>> findProdutoByCategoria(Categoria idCategoria);
}
