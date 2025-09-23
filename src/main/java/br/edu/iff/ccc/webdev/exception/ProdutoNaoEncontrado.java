package br.edu.iff.ccc.webdev.exception;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ProdutoNaoEncontrado extends RuntimeException {

    public ProdutoNaoEncontrado(String message) {
        super(message);
    }
    
    public ProblemDetail toProblemDetail() {
        ProblemDetail pb = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, this.getMessage());
        pb.setTitle("Produto Não Encontrado");
        pb.setType(URI.create("https://api.exemplo.com.br/erros/produto-nao-encontrado"));
        pb.setProperty("timestamp", Instant.now());
        return pb;
    }

}
