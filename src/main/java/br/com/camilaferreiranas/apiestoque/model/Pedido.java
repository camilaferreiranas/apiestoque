package br.com.camilaferreiranas.apiestoque.model;

import br.com.camilaferreiranas.apiestoque.enums.SituacaoPedidoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private SituacaoPedidoEnum situacaoPedido;

    @NotNull
    private Double valorTotal;

    @OneToMany
    private List<Produto> listaProdutos = new ArrayList<>();
}
