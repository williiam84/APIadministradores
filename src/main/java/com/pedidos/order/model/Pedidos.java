package com.pedidos.order.model;

public class Pedidos {
    String nome;
    String bairro;
    String rua;
    String formadepagamento;
    String observacao;
    Double total;

    public Pedidos(){

    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getBairro(){
        return this.bairro;
    }

    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    public String getRua(){
        return this.rua;
    }

    public void setRua(String rua){
        this.rua = rua;
    }

    public String getFormadepagamento(){
        return this.formadepagamento;
    }

    public void setFormadepagamento(String formadepagamento){
        this.formadepagamento = formadepagamento;
    }

    public String getObservacao(){
        return this.observacao;
    }

    public void setObservacao(String observacao){
        this.observacao = observacao;
    }

    public Double getTotal(){
        return this.total;
    }

    public void setTotal(Double total){
        this.total = total;
    }
}
