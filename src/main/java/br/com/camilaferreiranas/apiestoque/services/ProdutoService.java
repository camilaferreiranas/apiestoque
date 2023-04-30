package br.com.camilaferreiranas.apiestoque.services;

import br.com.camilaferreiranas.apiestoque.dto.ProdutoDto;
import br.com.camilaferreiranas.apiestoque.model.Categoria;
import br.com.camilaferreiranas.apiestoque.model.Produto;
import br.com.camilaferreiranas.apiestoque.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;


    public Produto salvarProduto(ProdutoDto dto) {
        Produto produto = new Produto();
        produto.setValorUnitario(dto.getValorUnitario());
        produto.setTitulo(dto.getTitulo());
        produto.setDescricao(dto.getDescricao());
        produto.setCategoria(dto.getCategoria());
        return produtoRepository.save(produto);
    }

    public List<Produto> findAllProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<List<Produto>> findProdutoByValor(Double valor) {
        return produtoRepository.findProdutoByValorUnitario(valor);
    }

    public Optional<List<Produto>> findProdutoByCategoria(Categoria idCategoria) {
        return produtoRepository.findProdutoByCategoria(idCategoria);
    }
}
