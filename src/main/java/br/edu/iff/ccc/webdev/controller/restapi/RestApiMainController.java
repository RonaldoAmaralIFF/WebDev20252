package br.edu.iff.ccc.webdev.controller.restapi;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path = "/api/v1")
public class RestApiMainController {

    @GetMapping(path = "/exemplo")
 // Endpoint to handle requests to the API home
    public ResponseEntity<String> getApiHome() {
        return ResponseEntity.ok("Em implementação");
    }

    @GetMapping(path = "/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("API is running");
    }   
    

    @Operation(summary = "Retorna todos os exemplos armazenados")
	@ApiResponses({
		@ApiResponse(responseCode = "200")
	})
    @GetMapping(path = "/itens")
    // Endpoint to retrieve all items
    public ResponseEntity<List<Map<String,String>>> getAllItems() {
    // Logic to retrieve all items
    List<Map<String,String>> itens = List.of(
        Map.of("id", "1", "name", "Item 1"),
        Map.of("id", "2", "name", "Item 2")
    );
    return ResponseEntity.ok(itens);
}

    @GetMapping
    public ResponseEntity<Map<String, Object>> getApiRoot() {
        // Usamos LinkedHashMap para manter a ordem de inserção no JSON final
        Map<String, Object> responseBody = new LinkedHashMap<>();

        // Informações básicas sobre a API
        responseBody.put("api_name", "API de Gestão de E-commerce");
        responseBody.put("version", "1.0.0");
        responseBody.put("timestamp", Instant.now().toString());
        responseBody.put("local_time", LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).toString());
        responseBody.put("location", "Campos dos Goytacazes, RJ, Brazil");

        // Links para os principais recursos (HATEOAS)
        Map<String, Map<String, String>> links = new LinkedHashMap<>();

        // Link para o próprio recurso raiz
        links.put("self", Map.of("href", buildLinkTo("/")));

        // Links para os outros recursos da API
        links.put("produtos", Map.of("href", buildLinkTo("/produtos")));
        links.put("pedidos", Map.of("href", buildLinkTo("/pedidos")));
        // Adicione outros recursos principais aqui...
        // links.put("clientes", Map.of("href", buildLinkTo("/clientes")));

        responseBody.put("_links", links);

        return ResponseEntity.ok(responseBody);
    }

    /**
     * Método utilitário para construir URLs completas e dinâmicas.
     * @param path O caminho do recurso (ex: "/produtos")
     * @return A URL completa (ex: "http://localhost:8080/api/v1/produtos")
     */
    private String buildLinkTo(String path) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1")
                .path(path)
                .build()
                .toUriString();
    }

}
