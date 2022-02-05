package com.br.api.backend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    double peso;
    String cepOrigem;
    String cepDestino;
    String nomeDestinatario;
    double vlTotalFrete;
    Date dataPrevistaEntrega;
    Date dataConsulta;


    public Pedido(double peso, String cepOrigem, String cepDestino, String nomeDestinatario, double valorFrete, LocalDate dataPrev, LocalDate dataConsulta) {
    }
}
