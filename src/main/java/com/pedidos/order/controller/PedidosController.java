package com.pedidos.order.controller;

import com.pedidos.order.bancodedados.BancoPedidos;
import com.pedidos.order.model.Pedidos;
import com.pedidos.order.service.PedidosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PedidosController {

    private final PedidosService pedidosService;

    public PedidosController(PedidosService pedidosService){
        this.pedidosService = pedidosService;
    }

    @PostMapping("/pedidos")
    public Pedidos CadastrarPedido(@RequestBody Pedidos pedidos, String nome, String bairro, String rua, String formadepagamento, String observacao, Double total){
        return pedidosService.pedidos(nome, bairro, rua, formadepagamento, observacao, total);
    }

    @GetMapping("/pedidos")
    public List<Pedidos> order(){
        return pedidosService.getBancoPedidos();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> Limpar(){
        pedidosService.limparhistorico();
        return ResponseEntity.noContent().build();
    }
}
