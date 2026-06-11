package com.pedidos.order.service;

import com.pedidos.order.bancodedados.BancoPedidos;
import com.pedidos.order.model.Pedidos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService {
    private final BancoPedidos bancoPedidos;

    public  PedidosService(BancoPedidos bancoPedidos){
        this.bancoPedidos = bancoPedidos;
    }

    String[] bairroscomtaxfixa = { "novo horizontino",
            "maria manteiga",
            "santana",
            "quilombo novo",
            "quilombo",
            "antonio lopez"};

    //FAZENDO PEDIDO
    public Pedidos pedidos(String nome, String bairro, String rua,
                           String formadepagamento, String observacao, Double total) {

        if (total == null || total < 21.00) {
            throw new RuntimeException("Erro: pedido mínimo de R$ 21,00");
        }

        double totalFinal = total;

        // taxa base
        if (
                bairro.equalsIgnoreCase("novo horizontino") ||
                        bairro.equalsIgnoreCase("maria manteiga")
        ) {
            totalFinal += 3.00;
        }
        else if (
                bairro.equalsIgnoreCase("santana") ||
                        bairro.equalsIgnoreCase("quilombo novo") ||
                        bairro.equalsIgnoreCase("quilombo") ||
                        bairro.equalsIgnoreCase("antonio lopez")
        ) {
            totalFinal += 4.00;
        }else if(total < 35){
            totalFinal += 2.00;
        }else{
            totalFinal += 0;
        }



        Pedidos pedidos = new Pedidos();
        pedidos.setNome(nome);
        pedidos.setBairro(bairro);
        pedidos.setRua(rua);
        pedidos.setFormadepagamento(formadepagamento);
        pedidos.setObservacao(observacao);
        pedidos.setTotal(totalFinal);

        return pedidos;
    }
    //SALVAR PEDIDOS
    public BancoPedidos saveOrders(String nome, String bairro, String rua, String formadepagamento, String observacao, Double total) {

        Pedidos pedidos = pedidos(nome, bairro, rua, formadepagamento, observacao, total);

        bancoPedidos.getPedidos().add(pedidos);

        return bancoPedidos;
    }

    public void validacao(Pedidos pedidos) {

        if (pedidos.getTotal() < 21.00) {
            throw new RuntimeException("Pedido mínimo de R$ 21,00");
        }

        double totalFinal = pedidos.getTotal() + 2.00;

        if (
                pedidos.getBairro().equalsIgnoreCase("novo horizontino")
                        || pedidos.getBairro().equalsIgnoreCase("maria manteiga")
        ) {

            totalFinal += 3.00;

        } else if (
                pedidos.getBairro().equalsIgnoreCase("santana")
                        || pedidos.getBairro().equalsIgnoreCase("quilombo novo")
                        || pedidos.getBairro().equalsIgnoreCase("quilombo")
                        || pedidos.getBairro().equalsIgnoreCase("antonio lopez")
        ) {

            totalFinal += 4.00;
        }

        System.out.println("Pedido realizado com sucesso!");
        System.out.println("Total: R$ " + totalFinal);
    }

    public List<Pedidos> getBancoPedidos() {
        return bancoPedidos.getPedidos();
    }

    //LIMPAR HISTORICO
    public void limparhistorico(){
         bancoPedidos.getPedidos().clear();
    }
}
