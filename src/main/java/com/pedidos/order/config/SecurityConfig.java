package com.pedidos.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                // desativa proteção CSRF (API REST)
                .csrf(csrf -> csrf.disable())

                // regras de autorização
                .authorizeHttpRequests(auth -> auth

                        //  rotas públicas (não precisa login)
                        .requestMatchers("/api/login").permitAll()


                        //  rotas protegidas (precisa estar logado)
                        .requestMatchers("/api/lista/admin").authenticated()
                        .requestMatchers("/api/delete/**").authenticated()
                        .requestMatchers("/api/cadastro").permitAll()
                        .requestMatchers("/api/pedidos").permitAll()

                        // 🔒 qualquer outra rota precisa login
                        .anyRequest().authenticated()
                )

                .build();
    }
}