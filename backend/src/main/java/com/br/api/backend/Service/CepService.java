package com.br.api.backend.Service;

import com.br.api.backend.Models.Cep;
import com.br.api.backend.Service.feign.CepClient;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@AllArgsConstructor
@RestController
public class CepService {
    @Autowired
    private CepService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<Cep> getCep(@PathVariable String cep) {

        Cep endereco;
        endereco = CepClient.buscaEnderecoPorCep(cep);

        return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build();
    }
}
