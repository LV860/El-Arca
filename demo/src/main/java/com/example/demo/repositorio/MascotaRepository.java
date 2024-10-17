package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entidad.Mascota;
import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long>{

    List<Mascota> findMascotaByNombre(String nombre);
    List<Mascota> findMascotaByRaza(String raza);
    List<Mascota> findMascotaByEnfermedad(String enfermedad);
    List<Mascota> findMascotaByEstado(String estado);

    // Método para contar el total de mascotas
    long count();

    @Query("SELECT COUNT(m) FROM Mascota m WHERE m.estado = 'En tratamiento'")
    int countMascotasEnTratamiento();
}

