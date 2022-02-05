package com.br.api.backend.Service;

import com.br.api.backend.Models.Cep;
import com.br.api.backend.Models.Pedido;
import com.br.api.backend.Repository.PedidoRepository;
import com.br.api.backend.Service.dto.PedidoDto;
import com.br.api.backend.Service.feign.CepClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor

@CrossOrigin({"*"})
public class PedidoService {

    private final PedidoRepository repository;
    PedidoDto pedido;
    public Pedido savePedido(){
        return this.repository.save(calculaFrete(pedido));
    }



    public Pedido calculaFrete(PedidoDto dto){
        double valorFrete = 1 * dto.getPeso();

        Cep enderecoDest;
        enderecoDest = CepClient.buscaEnderecoPorCep(dto.getCepDestino());
        Cep enderecoOrig;
        enderecoOrig = CepClient.buscaEnderecoPorCep(dto.getCepOrigem());
        String ufOrigem = enderecoOrig.getUf();
        String ufDestino= enderecoDest.getUf();
        String dddOrigem = enderecoDest.getDdd();
        String dddDestino = enderecoOrig.getDdd();
        LocalDate dataConsulta = LocalDate.now() ;
        LocalDate dataPrev = LocalDate.now() ;

        if (ufOrigem.equals(ufDestino)){
            valorFrete = valorFrete *0.25;
            dataPrev.plusDays(3);

        }else if (dddDestino.equals(dddOrigem)) {
            valorFrete = valorFrete * 0.5;
            dataPrev.plusDays(1);
        }else{
            dataPrev.plusDays(10);
        }
        Pedido ped = new Pedido(dto.getPeso(), dto.getCepOrigem(), dto.getCepDestino(), dto.getNomeDestinatario(), valorFrete,dataPrev,dataConsulta);
        return ped;
    }


}
