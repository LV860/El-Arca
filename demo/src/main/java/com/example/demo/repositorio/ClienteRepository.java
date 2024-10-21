package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    List<Cliente> findClienteByNombre(String nombre);
    List<Cliente> findClienteByCorreo(String correo);
    List<Cliente> findClienteByCelular(String celular);
    List<Cliente> findClienteByCedula(Long cedula);
    List<Cliente> findClienteByEstado(String estado);
    Cliente findByCedula(Long cedula);

    @Query("SELECT c FROM Cliente c WHERE c.veterinario.id = :veterinarioId")
    List<Cliente> findClientesByVeterinarioId(@Param("veterinarioId") Long id);

}
