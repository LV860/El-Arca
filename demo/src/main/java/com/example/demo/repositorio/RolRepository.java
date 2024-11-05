package com.example.demo.repositorio;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidad.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
    List<Rol> findByName(String name);
}

