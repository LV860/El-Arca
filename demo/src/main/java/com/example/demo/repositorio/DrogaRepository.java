package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entidad.Droga;

public interface DrogaRepository extends JpaRepository<Droga, Long>{

    @Query("SELECT d.unidadesDisponibles FROM Droga d WHERE d.id = :id")
    int findUnidadesDisponiblesById(@Param("id") Long id);

    @Query("SELECT d.unidadesVendidas FROM Droga d WHERE d.id = :id")
    int findUnidadesVendidasById(@Param("id") Long id);


    
}
