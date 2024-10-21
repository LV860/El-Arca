package com.example.demo.Repositorio;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Tratamiento;
import com.example.demo.entidad.Veterinario;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.repositorio.VeterinarioRepository;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ClienteRepositorioTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

     @BeforeEach
    void setUp() {
        // Crear Veterinarios
        Veterinario veterinario1 = new Veterinario("11111111", "pass123", "Cirugía", "url1", "Dr. Pérez", "Activo");
        Veterinario veterinario2 = new Veterinario("22222222", "pass456", "Dermatología", "url2", "Dra. Sánchez", "Activo");

        veterinarioRepository.save(veterinario1);
        veterinarioRepository.save(veterinario2);

        // Crear Clientes
        Cliente cliente1 = new Cliente(123456789L, "cliente1@gmail.com", "3011111111", "Carlos López", "Activo");
        Cliente cliente2 = new Cliente(987654321L, "cliente2@gmail.com", "3022222222", "Ana Martínez", "Activo");

        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);

        // Crear Mascotas y asociarlas a Clientes
        Mascota mascota1 = new Mascota("Firulais", "Labrador", 3, 30.5, "Ninguna", "urlImagen1", cliente1.getCedula(), "Activo");
        mascota1.setCliente(cliente1); // Asignar cliente a la mascota

        Mascota mascota2 = new Mascota("Max", "Bulldog", 5, 25.0, "Alergias", "urlImagen2", cliente2.getCedula(), "Activo");
        mascota2.setCliente(cliente2); // Asignar cliente a la mascota

        mascotaRepository.save(mascota1);
        mascotaRepository.save(mascota2);

        /*// Crear Tratamientos y asociarlos a Mascotas y Veterinarios
        Tratamiento tratamiento1 = new Tratamiento(25.0, "2024-01-10", veterinario1, mascota1, null);
        Tratamiento tratamiento2 = new Tratamiento(30.0, "2024-01-10", veterinario2, mascota2, null);

        tratamientoRepository.save(tratamiento1);
        tratamientoRepository.save(tratamiento2);
        */
    }

    @Test
    public void ClienteRepository_save_Cliente(){
        //Arrange
        Cliente cliente = new Cliente(758463921L, "party.crashers@gmail.com", "3009876543", "Party Crashers", "Activo");

        //Act
        Cliente clienteGuardado = clienteRepository.save(cliente);

        //Assert
        Assertions.assertThat(clienteGuardado).isNotNull();
    }

    @Test
    public void ClienteRepository_FindAll_NotEmptyList(){
        //Arrange
        Cliente cliente = new Cliente(758463921L, "party.crashers@gmail.com", "3009876543", "Party Crashers", "Activo");
        Cliente cliente2 = new Cliente(758463922L, "party.crashers@gmail.com", "3009876543", "Party Crashers2", "Activo");

        //Act
        clienteRepository.save(cliente);
        clienteRepository.save(cliente2);
        List<Cliente> clientes = clienteRepository.findAll();

        //Assert
        Assertions.assertThat(clientes).isNotNull();
        Assertions.assertThat(clientes.size()).isEqualTo(4);
        Assertions.assertThat(clientes.size()).isGreaterThan(0);
    }

    @Test
    public void ClienteRepository_findById_FindWrongIndex(){
        //Arrange
        Long index = -1L;

        //Act
        Optional<Cliente> cliente = clienteRepository.findById(index);

        //Assert
        Assertions.assertThat(cliente).isEmpty();
    }
    
    @Test
    public void ClienteRepository_deleteById_EmptyCliente(){
        //Arrange
        Long index = 1L;

        //Act
        clienteRepository.deleteById(index);

        //Assert
        Assertions.assertThat(clienteRepository.findById(index)).isEmpty();
    }

    @Test
    public void ClienteRepository_findByCedula_Cliente(){
        //Arrange
        Long cedula = 123456789L;

        //Act
        Cliente cliente = clienteRepository.findByCedula(cedula);

        //Assert
        Assertions.assertThat(cliente).isNotNull();
    }

    /*@Test
    public void ClienteRepository_findClientesByVeterinarioId_CLienteList(){
        //Arrange
        Long id = 1L;

        //Act
        List<Cliente> clientes = clienteRepository.findClientesByVeterinarioId(id);

        //Assert
        Assertions.assertThat(clientes).isNotNull();
        Assertions.assertThat(clientes.size()).isGreaterThan(0);
        Assertions.assertThat(clientes.size()).isEqualTo(2);
    }*/

}