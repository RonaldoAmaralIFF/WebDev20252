package br.edu.iff.ccc.webdev.controller.restapi;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.webdev.entities.Produto;
import br.edu.iff.ccc.webdev.exception.ProdutoNaoEncontrado;
import br.edu.iff.ccc.webdev.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/v1/produtos")
@Tag(name = "Produtos", description = "Endpoints para gerenciamento de produtos")   
public class ProdutoApiController {
    
    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "Obter Produto", description = "Obtém os detalhes de um produto específico pelo seu ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado")
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

}
