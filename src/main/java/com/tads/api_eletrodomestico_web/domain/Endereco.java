package com.tads.api_eletrodomestico_web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    @Id
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id_cliente")
    @JsonIgnore
    private Cliente cliente;
    private String rua;
    private String cidade;
    private String bairro;
    private String cep;
    private int numCasa;

}
