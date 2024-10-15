package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidad.Veterinario;

public interface VeterinarioService {


    Veterinario findById(Long id);
    List<Veterinario> SearchAll();
    void delete(Long id);
    void update(Veterinario veterinario);
    void save(Veterinario veterinario);
}