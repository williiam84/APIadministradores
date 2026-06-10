package com.pedidos.order.bancodedados;

import com.pedidos.order.model.Pedidos;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BancoPedidos {
    public List<Pedidos> pedidos = new ArrayList<>();

    public List<Pedidos> getPedidos(){
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }
}
