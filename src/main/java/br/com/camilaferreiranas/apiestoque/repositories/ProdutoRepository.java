package br.com.camilaferreiranas.apiestoque.repositories;

import br.com.camilaferreiranas.apiestoque.model.Categoria;
import br.com.camilaferreiranas.apiestoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<List<Produto>> findProdutoByValorUnitario(Double valorUnitario);
    @Query(" from Produto p where p.categoria.id = :idCategoria")
    Optional<List<Produto>> findProdutoByCategoria(Long idCategoria);

    @Modifying
    @Query("update Produto p set p.valorUnitario = :novoValor where p.id = :idProduto")
    Produto criarPromocaoParaProduto(double novoValor, Long idProduto);
}
