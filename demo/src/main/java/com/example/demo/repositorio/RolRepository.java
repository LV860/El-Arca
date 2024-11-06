package com.example.demo.repositorio;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidad.Rol;
import com.example.demo.entidad.UserEntity;

public interface RolRepository extends JpaRepository<Rol, Long> {
     Optional<Rol> findByName(String name);
}

