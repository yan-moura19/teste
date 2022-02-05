package com.br.api.backend.Service.feign;

import com.br.api.backend.Models.Cep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface CepClient {

    @GetMapping("{cep}/json")
    static Cep buscaEnderecoPorCep(@PathVariable("cep") String cep){
        return null;
    };
}

