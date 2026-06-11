package com.pedidos.order.dto;

public class LoginRequest {
    private String email;
    private String senha;

    public LoginRequest(String email, String senha){
        this.email = email;
        this.senha = senha;
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
