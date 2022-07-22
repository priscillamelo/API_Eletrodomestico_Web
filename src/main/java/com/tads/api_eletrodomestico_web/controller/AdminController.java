package com.tads.api_eletrodomestico_web.controller;

import com.tads.api_eletrodomestico_web.domain.Cliente;
import com.tads.api_eletrodomestico_web.domain.Eletrodomestico;
import com.tads.api_eletrodomestico_web.service.ClienteService;
import com.tads.api_eletrodomestico_web.service.EletrodomesticoService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
        private final EletrodomesticoService eletrodomesticoService;

        public AdminController(EletrodomesticoService eletrodomesticoService) {
            this.eletrodomesticoService = eletrodomesticoService;
        }

        @GetMapping
        public ResponseEntity<List> listProdutos() {
            List<Eletrodomestico> lista = eletrodomesticoService.listProdutosNotDeleted();
            return ResponseEntity.ok(lista);
        }

        @PostMapping
        public ResponseEntity<Eletrodomestico> createProduto(@RequestBody Eletrodomestico eletrodomestico, Errors errors) throws URISyntaxException {
            Eletrodomestico produto = eletrodomesticoService.create(eletrodomestico);
            URI uri = new URI("/admin/" + produto.getId());
            return ResponseEntity.created(uri).body(produto);
        }

        @PatchMapping(path = "/{id}")
        public ResponseEntity<Eletrodomestico> updateProduto(@PathVariable Long id, @RequestBody Eletrodomestico eletrodomestico) {
            return eletrodomesticoService
                    .findById(id)
                    .map( record -> {
                                eletrodomesticoService.updateProduto(eletrodomestico);
                                return ResponseEntity.ok(eletrodomestico);
                            }).orElse(
                                ResponseEntity.notFound().build());

            /*if(eletrodomesticoService.findById(id) != null){
                Eletrodomestico produto = eletrodomesticoService.updateProduto(eletrodomestico);
                return ResponseEntity.ok(produto);
            } else {
                return ResponseEntity.notFound().build();
            }*/
        }
        @DeleteMapping(path = "/{id}")
        public ResponseEntity<?> doDeletar(@PathVariable Long id) {
            return eletrodomesticoService
                    .findById(id)
                    .map( record -> {
                        eletrodomesticoService.deleteProduto(id);
                        return ResponseEntity.ok().build();
                    }).orElse(
                            ResponseEntity.notFound().build());
        }
}
