package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidad.Administrador;
import com.example.demo.entidad.Droga;

public interface DrogaService {


    Droga findById(Long id);
    List<Droga> SearchAll();
}
