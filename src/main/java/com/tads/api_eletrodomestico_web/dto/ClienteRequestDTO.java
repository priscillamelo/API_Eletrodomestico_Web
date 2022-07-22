package com.tads.api_eletrodomestico_web.dto;

import com.tads.api_eletrodomestico_web.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDTO {
    String nome;
    String username;
    Endereco endereco;
}
