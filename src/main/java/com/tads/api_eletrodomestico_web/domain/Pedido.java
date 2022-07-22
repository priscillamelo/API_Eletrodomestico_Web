package com.tads.api_eletrodomestico_web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    private Long id;
    private float totalCompras;
    @ManyToOne
    @MapsId
    @JoinColumn(name = "id_cliente")
    @JsonIgnore
    private Cliente cliente;
}
