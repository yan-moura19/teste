package com.br.api.backend.Service.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class PedidoDto {

    double peso;
    String cepOrigem;
    String cepDestino;
    String nomeDestinatario;
}
