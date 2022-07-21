package com.tads.api_eletrodomestico_web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@NotBlank(message = ErrorsMessages.ErroCampoVazio)
    //@Min(value = 4, message = ErrorsMessages.ErroMinUsername)
    private String username;
    //@NotBlank(message = ErrorsMessages.ErroCampoVazio)
    //@Min(value = 6, message = ErrorsMessages.ErroMinPassword)
    private String password;
    //@NotBlank(message = ErrorsMessages.ErroCampoVazio)
    private String nome;
    //@NotBlank(message = ErrorsMessages.ErroCampoVazio)
    //@Email(message = ErrorsMessages.ErroEmail)
    private String email;
    //@ManyToMany
    //Endereco endereco;

}
