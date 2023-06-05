package br.com.camilaferreiranas.apiestoque.dto;

import lombok.Data;

@Data
public class ProdutoAtualizarDto {

    private String titulo;
    private double valorUnitario;
    private String descricao;
}
