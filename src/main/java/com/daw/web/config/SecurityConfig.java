package com.daw.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private JwtFilter jwtFilter;

    @SuppressWarnings(value = "all")
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
        		
        		.httpBasic().disable()
        		.csrf().disable()
                .cors()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests() // Para las peticiones HTTP
                
                // Reglas para usuarios
                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .requestMatchers(HttpMethod.GET, "/categories/**").permitAll() // Listar categorías para todos
                .requestMatchers(HttpMethod.GET, "/products/**", "/products/{id}/**", "/categories/{id}/products").permitAll() // Listar productos, obtener producto por ID y listar productos de una categoría para todos
                .requestMatchers(HttpMethod.POST, "/orders/**").hasRole("USER") // Crear un pedido
                .requestMatchers(HttpMethod.GET, "/orders/**").hasRole("USER") // Obtener un pedido
                .requestMatchers(HttpMethod.DELETE, "/orders/**").hasRole("USER") // Borrar un pedido
                .requestMatchers(HttpMethod.POST, "/orders/{id}/products/**").hasRole("USER") // Añadir productos al pedido
                
                // Reglas para administradores
                .requestMatchers(HttpMethod.POST, "/categories/**", "/products/**", "/users/**").hasRole("ADMIN") // Crear categorías, productos, usuarios
                .requestMatchers(HttpMethod.PUT, "/categories/**", "/products/**", "/users/**").hasRole("ADMIN") // Actualizar categorías, productos, usuarios
                .requestMatchers(HttpMethod.DELETE, "/categories/**", "/products/**", "/users/**").hasRole("ADMIN") // Borrar categorías, productos, usuarios
                .requestMatchers(HttpMethod.GET, "/orders/**").hasRole("ADMIN") // Listar y obtener pedidos
                .requestMatchers(HttpMethod.DELETE, "/orders/**").hasRole("ADMIN") // Borrar un pedido
                .requestMatchers(HttpMethod.PATCH, "/orders/{id}/status").hasRole("ADMIN") // Marcar un pedido como enviado
                
                .anyRequest()
                .authenticated() 
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
}
