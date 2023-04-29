package br.com.camilaferreiranas.apiestoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;

}
