package com.tads.api_eletrodomestico_web.controller;

import com.tads.api_eletrodomestico_web.service.ClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    ClienteService service;

    public ClienteController(ClienteService clienteService) {
        this.service = clienteService;
    }

    @GetMapping("/")
    public void getHomeClient(){

    }

    @PostMapping("/clientes/{id}")
    public void addProduto(@PathVariable Long id){

    }

    @PatchMapping("/clientes/editar/{id}")
    public void editClient(@PathVariable Long id){

    }

    @DeleteMapping("/clientes/{id}")
    public void deleteClient(@PathVariable Long id){

    }
}
