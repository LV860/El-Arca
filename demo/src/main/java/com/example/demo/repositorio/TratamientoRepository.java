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

    @Query(value = "SELECT COUNT(*) FROM tratamiento WHERE fecha >= ?1 AND fecha < ?2", nativeQuery = true)
    int countTratamientosByFechaAdministracionBetween(String fechaInicio, String fechaFin);


    @Query("SELECT d.nombre, COUNT(t) FROM Tratamiento t JOIN t.droga d WHERE t.Fecha >= :fechaInicio AND t.Fecha < :fechaFin GROUP BY d.nombre")
    List<Object[]> countTratamientosByDrogaLastMonth(@Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin);



    @Query("SELECT SUM(t.Precio + d.PrecioVenta) FROM Tratamiento t JOIN t.droga d")
    Float calcularVentasTotales(); // Devuelve un Float con el total de ventas

    // Método para calcular las ganancias totales

    @Query("SELECT SUM(t.Precio) + SUM((d.PrecioVenta - d.PrecioCompra)) FROM Tratamiento t JOIN t.droga d")
    Float calcularGananciasTotales(); // Devuelve un Float con el total de ganancias


}