package br.com.camilaferreiranas.apiestoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double valorUnitario;

    @NotNull
    private String titulo;

    private String descricao;

    @OneToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    private Categoria categoria;
}
