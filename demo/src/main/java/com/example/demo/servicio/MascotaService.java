package com.example.demo.servicio;

import java.util.Collection;
import java.util.List;

import com.example.demo.entidad.Mascota;


public interface MascotaService {

    public Mascota SearchById(Long id);
    public List<Mascota> SearchAll();
    public void deleteById(Long id);
    public Mascota update(Mascota mascota);
    public Mascota save(Mascota mascota);
    public Collection<Mascota> findMascotaByNombre(String nombre);
    public Collection<Mascota> findMascotaByRaza(String raza);
    public Collection<Mascota> findMascotaByEnfermedad(String enfermedad);
    public Collection<Mascota> findMascotaByEstado(String estado);
    public int getTotalMascotas();
    public int getTotalMascotasEnTratamiento();
} 
