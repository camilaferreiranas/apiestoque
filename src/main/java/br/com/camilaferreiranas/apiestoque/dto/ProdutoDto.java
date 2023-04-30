package br.com.camilaferreiranas.apiestoque.dto;

import br.com.camilaferreiranas.apiestoque.model.Categoria;
import lombok.Data;

@Data
public class ProdutoDto {

    private double valorUnitario;
    private String titulo;
    private String descricao;
    private Categoria categoria;
}
