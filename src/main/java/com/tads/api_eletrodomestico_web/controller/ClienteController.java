package com.tads.api_eletrodomestico_web.controller;

import com.tads.api_eletrodomestico_web.domain.Cliente;
import com.tads.api_eletrodomestico_web.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    ClienteService service;

    public ClienteController(ClienteService clienteService) {
        this.service = clienteService;
    }

    @GetMapping
    public List<Cliente> listClients(){
        return service.list();
    }
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) throws URISyntaxException {
        Cliente user = service.addClient(cliente);
        URI uri = new URI("/clientes/" + user.getId());
        return ResponseEntity.created(uri).body(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> editClient(@PathVariable Long id, @RequestBody Cliente cliente){
        return service
                .findById(id)
                .map( record -> {
                    service.updateClient(cliente);
                    return ResponseEntity.ok(cliente);
                }).orElse(
                        ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id){
        return service
                .findById(id)
                .map( record -> {
                    service.deleteClient(id);
                    return ResponseEntity.ok().build();
                }).orElse(
                        ResponseEntity.notFound().build());
    }
}
