package com.example.demo.Servicio;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entidad.Cliente;
import com.example.demo.servicio.ClienteService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class ClienteServicioTest {

    @Autowired
    private ClienteService clienteService;

    private Cliente cliente1;
    private Cliente cliente2;

    @BeforeEach
    public void setUp() {
        cliente1 = new Cliente(123456789L, "ana.perez@gmail.com", "3012345678", "Ana Pérez", "Inactivo");
        cliente2 = new Cliente(987654321L, "juan.perez@gmail.com", "3112347378", "Juan Pérez", "Inactivo");
    }

    @Test
    public void clienteServicioTest_crearCliente_Cliente() {
        // Act
        Cliente nuevoCliente1 = clienteService.crearCliente(cliente1);
        Cliente nuevoCliente2 = clienteService.crearCliente(cliente2);

        // Assert
        Assertions.assertThat(nuevoCliente1).isNotNull();
        Assertions.assertThat(nuevoCliente2).isNotNull();
    }

    @Test
    public void clienteServicioTest_findAll_ClienteList() {
        // Act
        List<Cliente> clientes = clienteService.SearchAll();

        // Assert
        Assertions.assertThat(clientes).isNotNull();
        Assertions.assertThat(clientes.size()).isEqualTo(0);
    }

    @Test
    public void clienteServicioTest_findById_Cliente() {
        // Act
        Cliente cliente = clienteService.findById(1L);

        // Assert
        Assertions.assertThat(cliente).isNull();
    }

    @Test
    public void clienteServicioTest_deleteCliente() {
        // Act
        clienteService.eliminarCliente(1L);

        // Assert
        Assertions.assertThat(clienteService.findById(1L)).isNull();
    }
}