package com.pedidos.order.model;

public class Admin {
    private String usuario;
    private String email;
    private String senha;

    public Admin(String usuario, String email, String senha){
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
    }

    public Admin(){

    }

    public String getUsuario(){
        return this.usuario;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha(){
        return this.senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
}
