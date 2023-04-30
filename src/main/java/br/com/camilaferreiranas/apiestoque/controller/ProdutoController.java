package br.com.camilaferreiranas.apiestoque.controller;

import br.com.camilaferreiranas.apiestoque.dto.ProdutoDto;
import br.com.camilaferreiranas.apiestoque.model.Categoria;
import br.com.camilaferreiranas.apiestoque.model.Produto;
import br.com.camilaferreiranas.apiestoque.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RequestMapping("/produto")
@RestController
@AllArgsConstructor
@Tag(name = "Controller de Produto")
public class ProdutoController {

    private final ProdutoService service;

    @Operation(summary = "Endpoint para cadastro de produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto cadastrado",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Produto.class)) }),
            @ApiResponse(responseCode = "500", description = "Houve um erro ao cadastrar o produto",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Não foi possível cadastrar o produto",
                    content = @Content) })
    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody ProdutoDto dto) {
        return ResponseEntity.ok(service.salvarProduto(dto));
    }


    @Operation(summary = "Endpoint para buscar todos os produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de produtos",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Produto.class)) }),
            @ApiResponse(responseCode = "500", description = "Houve um erro ao buscar os produtos",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Não foi possível buscar os produtos",
                    content = @Content) })
    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        return ResponseEntity.ok(service.findAllProdutos());
    }

    @Operation(summary = "Endpoint para buscar um produto de um determinado valor" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de produtos de com determinado valor",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Produto.class)) }),
            @ApiResponse(responseCode = "500", description = "Houve um erro ao buscar os produtos",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Não foi possível buscar os produtos",
                    content = @Content) })
    @GetMapping("/valor/{valor}")
    public ResponseEntity<Optional<List<Produto>>> findProdutoPorValor(@PathVariable Double valor) {
        return ResponseEntity.ok(service.findProdutoByValor(valor));
    }


    @Operation(summary = "Endpoint para buscar um produto de uma determinada categoria" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de produtos com determinada categoria",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Produto.class)) }),
            @ApiResponse(responseCode = "500", description = "Houve um erro ao buscar os produtos",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Não foi possível buscar os produtos",
                    content = @Content) })
    @GetMapping("/categoria")
    public ResponseEntity<Optional<List<Produto>>> findProdutoPorCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(service.findProdutoByCategoria(categoria));
    }
}
