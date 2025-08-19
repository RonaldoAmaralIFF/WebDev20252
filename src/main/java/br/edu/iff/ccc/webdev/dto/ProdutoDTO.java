package br.edu.iff.ccc.webdev.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProdutoDTO
{       
    
    private Long id;
    @NotBlank(message = "O nome do produto não pode ser vazio.")
    @Size(min = 1, max = 100, message = "O nome do produto deve ter entre 1 e 100 caracteres.") 
    private String nome;
    
    @NotBlank(message = "A descrição do produto não pode ser vazia.")
    @Size(min = 1, max = 255, message = "A descrição do produto deve ter entre 1 e 255 caracteres.")       
    private String descricao;
    @NotBlank(message = "A categoria do produto não pode ser vazia.")
    @Size(min = 1, max = 50, message = "A categoria do produto deve ter entre 1 e 50 caracteres.")
    private String categoria;
    @NotBlank(message = "A quantidade em estoque não pode ser vazia.")
    @Size(min = 1, max = 10, message = "A quantidade em estoque deve ser um número válido.")    
    private int quantidadeEstoque;
    @NotBlank(message = "O preço do produto não pode ser vazio.")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero.")
    private BigDecimal preco;


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

}
