package com.pedidos.order.controller;

<<<<<<< HEAD
import com.pedidos.order.bancodedados.BancoAdmin;
=======
>>>>>>> 2a15bb3 (salvando alterações antes do pull)
import com.pedidos.order.dto.LoginRequest;
import com.pedidos.order.model.Admin;
import com.pedidos.order.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
                admin.getSenha()
        );
    }

    @GetMapping("/lista/admin")
    public List<Admin> listar(){
        return adminService.Listar();
    }

    @PostMapping("/login")
<<<<<<< HEAD
    public ResponseEntity<?> login(@RequestBody LoginRequest dados){
        return ResponseEntity.ok(
                adminService.login(dados.getEmail(), dados.getSenha())
=======
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest req) {

        String token = adminService.login(req.getEmail(), req.getSenha());

        if (token == null) {
            return ResponseEntity.status(401)
                    .body(Map.of("error", "Login inválido"));
        }

        return ResponseEntity.ok(
                Map.of("token", token)
>>>>>>> 2a15bb3 (salvando alterações antes do pull)
        );
    }
}
