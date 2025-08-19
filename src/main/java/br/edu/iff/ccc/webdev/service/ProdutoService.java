package br.edu.iff.ccc.webdev.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import br.edu.iff.ccc.webdev.entities.Produto;

@Service
public class ProdutoService {

    public void saveProduto(Produto produto) {
        // Implement the logic to save the product
        // This could involve calling a repository to persist the product in a database
        System.out.println("ID: " + produto.getId() + " Nome: " + produto.getNome() + " Preço: " + produto.getPreco() +
        " Descrição: " + produto.getDescricao() + " Quantidade em Estoque: " + produto.getQuantidadeEstoque() + " Categoria: " + produto.getCategoria())    ;       
    }

    public Produto findProdutoById(Long id) {

        Produto produto = new Produto();
        // Simulating a product retrieval by ID
        // In a real application, you would retrieve the product from a database
        if (id == null) {
            return null; // Return null if the ID is not provided
        }
        // For demonstration purposes, we will create a dummy product
        // In a real application, you would fetch the product from a database
    
        produto.setId(id);
        produto.setNome("Produto Exemplo");
        produto.setPreco(new BigDecimal(100.0));
        produto.setDescricao("Descrição do Produto Exemplo");
        produto.setQuantidadeEstoque(50);
        produto.setCategoria("Categoria Exemplo");      
        return produto;

    }
    public ArrayList<Produto> findAllProdutos() {
        // Implement the logic to retrieve all products
        // This could involve calling a repository to get all products from a database
        Produto produto1 = new Produto(1L, "Produto 1", new BigDecimal("1.00"), "Descrição do Produto 1", 20, "Categoria A");
        Produto produto2 = new Produto(2L, "Produto 2", new BigDecimal("5.0"), "Descrição do Produto 2", 15, "Categoria B");
        Produto produto3 = new Produto(3L, "Produto 3", new BigDecimal("120.0"), "Descrição do Produto 3", 30, "Categoria A");   
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        return produtos; // Return the list of products
    }

}
