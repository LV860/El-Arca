package com.example.demo.servicio;

import java.util.Collection;

import com.example.demo.entidad.Tratamiento;

public interface TratamientoService {


    Tratamiento findById(Long id);
    Collection<Tratamiento> SearchAll();
    void delete(Long id);
    void update(Tratamiento tratamiento);
    void save(Tratamiento tratamiento);
}
