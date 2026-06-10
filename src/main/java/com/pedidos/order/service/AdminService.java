package com.pedidos.order.service;

import com.pedidos.order.bancodedados.BancoAdmin;
import com.pedidos.order.model.Admin;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class AdminService {
    private final BancoAdmin bancoAdmin;
    private final List<Admin> administradores;
    private final Map<String, Admin> tokens = new HashMap<>();
    public AdminService(BancoAdmin bancoAdmin, List<Admin> administradores){
        this.bancoAdmin = bancoAdmin;
        this.administradores = administradores;
    }

    //CADASTRAR ADMIN
    public Admin RegisterAdmin(String usuario, String email, String senha){
        Admin admin = new Admin();
        admin.setUsuario(usuario);
        admin.setEmail(email);
        admin.setSenha(senha);
        return admin;
    }

    //SALAVAR
    public Admin saveAdmin(String usuario, String email, String senha){
        Admin admin = RegisterAdmin(usuario, email, senha);
        bancoAdmin.getAdministradores().add(admin);
        return admin;
    }

    //listas
    public List<Admin> Listar() {
        return bancoAdmin.getAdministradores();
    }

    public Admin buscarPorEmail(String email){
        return administradores.stream()
                .filter(p -> p.getEmail() == p.getEmail())
                .findFirst()
                .orElse(null);
    }


    //LOGIN
    public String login(String email, String senha){

        Admin admin = buscarPorEmail(email);

        if(admin != null &&
                admin.getSenha().equals(senha)){
            return "login efetuado com SUCESSO!";
        }

        return "ALGO ESTÁ INCORRETO";
    }

    public boolean tokenValido(String token){
        return tokens.containsKey(token);
    }
}
