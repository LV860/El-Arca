package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{
    
    @Query("SELECT COUNT(v) FROM Veterinario v WHERE v.estado = :estado")
    int countVeterinariosByEstado(@Param("estado") String estado);
    Veterinario findByCedula(String cedula);

    
}