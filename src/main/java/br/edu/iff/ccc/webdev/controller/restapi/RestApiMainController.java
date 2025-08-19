package br.edu.iff.ccc.webdev.controller.restapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "/api/v1")
public class RestApiMainController {

    @GetMapping()
 // Endpoint to handle requests to the API home
    public ResponseEntity<String> getApiHome() {
        return ResponseEntity.ok("Em implementação");
    }


}
