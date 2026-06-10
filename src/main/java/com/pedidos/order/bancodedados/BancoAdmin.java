package com.pedidos.order.bancodedados;

import com.pedidos.order.model.Admin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BancoAdmin {
    public List<Admin> administradores = new ArrayList<>();

    public List<Admin> getAdministradores(){
        return administradores;
    }

    public void setAdministradores(List<Admin> administradores) {
        this.administradores = administradores;
    }
}

