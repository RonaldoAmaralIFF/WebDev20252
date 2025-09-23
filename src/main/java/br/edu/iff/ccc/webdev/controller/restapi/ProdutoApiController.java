package br.edu.iff.ccc.webdev.controller.restapi;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.webdev.entities.Produto;
import br.edu.iff.ccc.webdev.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api/v1/produtos")
@Tag(name = "Produtos", description = "Endpoints para gerenciamento de produtos")   
public class ProdutoApiController {
    
    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "Obter Produto", description = "Obtém os detalhes de um produto específico pelo seu ID")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Produto encontrado com sucesso",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Produto.class)
            )               
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Produto não encontrado",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ProblemDetail.class)
            )
        )
    })
    @GetMapping("/{id}")
    public ResponseEntity<Produto>  getProduto(@PathVariable Long id){    
        Produto produto = produtoService.findProdutoById(id);  
        return ResponseEntity.ok(produto);

    }

    @Operation(summary = "Listar Produtos", description = "Lista todos os produtos cadastrados no sistema")
    @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso")
    @GetMapping
    public ResponseEntity<ArrayList> getProdutos() {
        ArrayList produtos = produtoService.findAllProdutos();
        return ResponseEntity.ok(produtos);
    }


    @Operation(summary = "Criar Produto", description = "Cria um novo produto no sistema")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201", 
            description = "Produto criado com sucesso",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Produto.class)
            )               
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Requisição inválida",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ProblemDetail.class)
            )
        )
    })

    @PostMapping()
    public ResponseEntity<Produto> novoProduto(@Valid @RequestBody Produto produto) {
        produtoService.saveProduto(produto);
        // Cria a URI do novo recurso criado
        URI location = URI.create(String.format("/api/v1/produtos/%s", produto.getId()));
        // Retorna a resposta com o status 201 Created e o corpo contendo o produto criado
        return ResponseEntity.created(location).body(produto);
    }
    

}
