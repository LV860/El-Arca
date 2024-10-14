package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Administrador;
import com.example.demo.entidad.Cliente;



@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long>{
    
    Administrador findByUsuario(String usuario);
    
    
}
    

