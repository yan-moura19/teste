package com.br.api.backend.Controllers;

import com.br.api.backend.Models.Pedido;
import com.br.api.backend.Repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor


public class PedidoController {


    private PedidoRepository repository;


    @GetMapping("/pedido")
    public List<Pedido> getAllPedidos(){
        return repository.findAll();
    }

    @PostMapping("/save-pedido")
    public Pedido savePedido(@RequestBody Pedido pedido){
        return repository.save(pedido);
    }

    @GetMapping("/pedido/{id}")
    public Pedido getPedidoById(@PathVariable Long id){
        return repository.findById(id).get();
    }
    @DeleteMapping("/pedido/{id}")
    public void deletePedido(@PathVariable Long id){
        repository.deleteById(id);
    }
}
