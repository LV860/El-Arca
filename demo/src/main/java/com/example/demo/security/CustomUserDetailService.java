package com.example.demo.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Administrador;
import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Rol;
import com.example.demo.entidad.UserEntity;
import com.example.demo.repositorio.RolRepository;
import com.example.demo.repositorio.UserRepository;
import com.example.demo.repositorio.VeterinarioRepository;

import com.example.demo.entidad.Veterinario;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userDB = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Usuario no encontrado"));

        UserDetails userDetails = new User(userDB.getUsername(), userDB.getPassword(),
                mapToGrantedAuthorities(userDB.getRoles()));

        return userDetails;
    }

    // Rol que esta en la BD a GrantedAuthority
    // Pasar de rol al otro tipo de lista
    // Convertir Rol entities a GrantedAuthority
    private Collection<GrantedAuthority> mapToGrantedAuthorities(List<Rol> roles) {
        return roles.stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getName()))
                .collect(Collectors.toList());
    }

    // Cliente no tiene contraseña por ende "123"
    public UserEntity ClienteToUser(Cliente cliente) {
        UserEntity user = new UserEntity();
        user.setUsername(cliente.getCedula().toString());
        user.setPassword(passwordEncoder.encode("123"));

        Rol rol = rolRepository.findByName("DUEÑO").get();
        user.setRoles(List.of(rol));
        return user;
    }

    public UserEntity VeterinarioToUser(Veterinario veterinario) {
        UserEntity user = new UserEntity();
        user.setUsername(veterinario.getCedula());
        user.setPassword(passwordEncoder.encode(veterinario.getContrasena()));

        Rol rol = rolRepository.findByName("VETERINARIO").get();
        user.setRoles(List.of(rol));
        return user;
    }

    public UserEntity AdministradorToUser(Administrador administrador) {
        UserEntity user = new UserEntity();
        user.setUsername(administrador.getUsuario());
        user.setPassword(passwordEncoder.encode(administrador.getContrasena()));

        Rol rol = rolRepository.findByName("ADMIN").get();
        user.setRoles(List.of(rol));
        return user;
    }

}
