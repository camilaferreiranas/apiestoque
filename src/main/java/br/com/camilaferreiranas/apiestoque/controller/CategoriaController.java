package br.com.camilaferreiranas.apiestoque.controller;

import br.com.camilaferreiranas.apiestoque.dto.CategoriaDto;
import br.com.camilaferreiranas.apiestoque.model.Categoria;
import br.com.camilaferreiranas.apiestoque.services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/categoria")
@RestController
@AllArgsConstructor
@Tag(name = "Controller de Categoria")
public class CategoriaController {

    private CategoriaService service;

    @Operation(summary = "Endpoint para cadastro de categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria cadastrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Categoria.class)) }),
            @ApiResponse(responseCode = "500", description = "Houve um erro ao cadastrar a categoria",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Não foi possível cadastrar a categoria",
                    content = @Content) })
    @PostMapping
    public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody CategoriaDto dto) {
        return ResponseEntity.ok(service.salvarCategoria(dto));
    }

    @Operation(summary = "Endpoint para buscar todas as categorias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de categorias",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Categoria.class)) }),
            @ApiResponse(responseCode = "500", description = "Houve um erro ao buscar as categorias",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Não foi possível buscar as categorias",
                    content = @Content) })
    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return ResponseEntity.ok(service.getAllCategorias());
    }

    @Operation(summary = "Endpoint para buscar categoria pela descrição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Categoria.class)) }),
            @ApiResponse(responseCode = "500", description = "Houve um erro ao buscar a categoria",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Não foi possível buscar a categoria",
                    content = @Content) })
    @GetMapping("/{descricao}")
    public ResponseEntity<Optional<Categoria>> getCategoriaByDescricao(@PathVariable String descricao) {
        return ResponseEntity.ok(service.getCategoriaByDescricao(descricao));
    }
}
