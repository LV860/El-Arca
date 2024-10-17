package com.example.demo.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {

    Collection<Tratamiento> findByMascotaId(Long mascota_id);

    Collection<Tratamiento> findByVeterinarioId(Long cliente_id);

}