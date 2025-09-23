package br.edu.iff.ccc.webdev.exception;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiGlobalAdviceException {

    @ExceptionHandler(ProdutoNaoEncontrado.class)
    public ProblemDetail handleProdutoNaoEncontrado(HttpServletRequest req, ProdutoNaoEncontrado e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Produto Não Encontrado");    
        problemDetail.setProperty("url", req.getRequestURL().toString());
        problemDetail.setProperty("timestamp", LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString());  
        problemDetail.setProperty("status", HttpStatusCode.valueOf(problemDetail.getStatus()).toString());  
        problemDetail.setProperty("message", e.getMessage());
        problemDetail.setProperty("exception", e.getClass().getName());
        problemDetail.setProperty("path", req.getRequestURI());
        return problemDetail;
    }


   @ExceptionHandler(RuntimeException.class)
   public ProblemDetail defaltErrorHandler(HttpServletRequest req, Exception e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        problemDetail.setTitle(e.getClass().getSimpleName());    
        problemDetail.setProperty("url", req.getRequestURL().toString());
        problemDetail.setProperty("timestamp", LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString());  
        problemDetail.setProperty("status", HttpStatusCode.valueOf(problemDetail.getStatus()).toString());  
        problemDetail.setProperty("message", e.getMessage());
        problemDetail.setProperty("exception", e.getClass().getName());
        problemDetail.setProperty("path", req.getRequestURI());
        return problemDetail;
   }


}
