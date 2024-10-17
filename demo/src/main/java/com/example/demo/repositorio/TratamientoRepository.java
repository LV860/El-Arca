package com.example.demo.repositorio;

import java.util.Collection;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {

    Collection<Tratamiento> findByMascotaId(Long mascota_id);

    Collection<Tratamiento> findByVeterinarioId(Long cliente_id);

}