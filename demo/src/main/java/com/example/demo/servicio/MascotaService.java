package com.example.demo.servicio;

import java.util.Collection;


import com.example.demo.entidad.Mascota;


public interface MascotaService {

    public Mascota SearchById(Long id);
    public Collection<Mascota> SearchAll();
    public void deleteById(Long id);
    public void update(Mascota mascota);
    public void save(Mascota mascota);
    //public Collection<Mascota> findMascotaByClienteId(Long id);
    
} 
