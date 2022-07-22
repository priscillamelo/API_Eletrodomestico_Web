package com.tads.api_eletrodomestico_web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tads.api_eletrodomestico_web.controller.ClienteController;
import com.tads.api_eletrodomestico_web.domain.Endereco;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class ClienteResponseDTO extends RepresentationModel<ClienteResponseDTO> {
    @JsonIgnore
    Long id;
    String nome;
    String username;
    String password;
    String email;
    Endereco endereco;

    public void addHateoasLinks(Long id) {
        this.add(linkTo(ClienteController.class).slash(id).withSelfRel());
        this.add(linkTo(ClienteController.class).withRel("GET"));
        this.add(linkTo(ClienteController.class).slash(id).withRel("DELETE"));
        this.add(linkTo(ClienteController.class).slash(id).withRel("PUT"));
        this.add(linkTo(ClienteController.class).withRel("POST"));
    }
}
