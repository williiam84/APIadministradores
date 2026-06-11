package com.pedidos.order.controller;

import com.pedidos.order.bancodedados.BancoAdmin;
import com.pedidos.order.dto.LoginRequest;
import com.pedidos.order.model.Admin;
import com.pedidos.order.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AdminController {
    private final AdminService adminService;
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/cadastro")
    public Admin cadastraradmin(@RequestBody Admin admin){
        return adminService.saveAdmin(
                admin.getUsuario(),
                admin.getEmail(),
                admin.getSenha(),
                admin.getId()
        );
    }

    @GetMapping("/lista/admin")
    public List<Admin> listar(){
        return adminService.Listar();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest dados){
        return ResponseEntity.ok(
                adminService.login(dados.getEmail(), dados.getSenha())
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> Deletar(@PathVariable Integer id){
        adminService.deletarAdministrador(id);
        return ResponseEntity.ok(). build();
    }
}
