package com.tads.api_eletrodomestico_web.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pedido> pedido;

}
