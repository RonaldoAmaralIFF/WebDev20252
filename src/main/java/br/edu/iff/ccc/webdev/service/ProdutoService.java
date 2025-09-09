package br.edu.iff.ccc.webdev.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.webdev.entities.Produto;
import br.edu.iff.ccc.webdev.exception.ProdutoNaoEncontrado;
import br.edu.iff.ccc.webdev.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired  
    ProdutoRepository produtoRepository;

    public void saveProduto(Produto produto) {     
        produtoRepository.save(produto);
    }

    public Produto findProdutoById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ProdutoNaoEncontrado("Produto com id " + id + " não encontrado.")); 
        //return produtoRepository.findById(id).isPresent() ? produtoRepository.findById(id).get() : null;
        
    }

    public ArrayList<Produto> findAllProdutos() {
        return (ArrayList<Produto>) produtoRepository.findAll();
    }

}
