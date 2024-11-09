package com.example.demo.security;

import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.method.P;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthEntryPoint jwtAuthEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(frame -> frame.disable()))
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/h2/**").permitAll()
                        .requestMatchers("/veterinario/login").permitAll()
                        .requestMatchers("/clientes/login").permitAll()
                        .requestMatchers("/admin/login").permitAll()
                        .requestMatchers("/veterinario/find/**").hasAuthority("VETERINARIO")
                        .requestMatchers("/clientes/find/**").hasAuthority("DUEÑO")
                        .requestMatchers("/clientes/find/**").hasAuthority("VETERINARIO")
                        .requestMatchers("/admin/find/**").hasAuthority("ADMIN")
                        .requestMatchers("/veterinario/details").hasAuthority("VETERINARIO")
                        .requestMatchers("/clientes/details").hasAuthority("DUEÑO")
                        .requestMatchers("/dashboard/**").hasAuthority("ADMIN")
                        .requestMatchers("/veterinario/all").hasAuthority("ADMIN")
                        .requestMatchers("/admin/details").hasAuthority("ADMIN")
                        .requestMatchers("/mascota/all").hasAuthority("VETERINARIO")
                        .requestMatchers("/mascota/all").hasAuthority("ADMIN")
                        .requestMatchers("/tratamiento/add").hasAuthority("VETERINARIO")
                        .requestMatchers("/tratamiento/findByMascotaId/**").hasAuthority("VETERINARIO")
                        .requestMatchers("/tratamiento/findByVeterinarioId/**").hasAuthority("VETERINARIO")
                        .requestMatchers("/tratamiento/add").hasAuthority("ADMIN")
                        .requestMatchers("/tratamiento/findByMascotaId/**").hasAuthority("ADMIN")
                        .requestMatchers("/tratamiento/findByVeterinarioId/**").hasAuthority("ADMIN")
                        .anyRequest().permitAll())
                .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthEntryPoint));
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter();
    }
}
