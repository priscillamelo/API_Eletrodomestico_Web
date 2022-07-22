package com.tads.api_eletrodomestico_web.domain;

import com.tads.api_eletrodomestico_web.errorhandling.ApiErroMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Eletrodomestico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = ApiErroMessages.ErroCampoVazio)
    private String nome;
    //@NotBlank(message = ApiErroMessages.ErroCampoVazio)
    private String marca;
    //@NotBlank(message = ApiErroMessages.ErroCampoVazio)
    private String descricao;
    // @NotBlank(message = ApiErroMessages.ErroCampoVazio)
    private String imageUri;
    //@PositiveOrZero(message = ApiErroMessages.ErroNumeroPositivo)
    private float preco;
    private float avaliacao;
    //@PositiveOrZero(message = ApiErroMessages.ErroNumeroPositivo)
    private int quantidade;
    private Date deleted;
}
