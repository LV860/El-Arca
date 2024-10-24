package com.example.demo.Servicio;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.entidad.Cliente;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.servicio.ClienteServiceImpl;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ClienteServicioTestMock {

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Mock
    ClienteRepository clienteRepository;

    private Cliente cliente1;
    private Cliente cliente2;

    @BeforeEach
    public void setUp() {
        //cliente1 = new Cliente(123456789L, "ana.perez@gmail.com", "3012345678", "Ana Pérez", "Inactivo");
        //cliente2 = new Cliente(987654321L, "juan.perez@gmail.com", "3112347378", "Juan Pérez", "Inactivo");
    }

    @Test
    public void clienteServicioTest_crearCliente_Cliente() {
        // Arrange
        Cliente cliente = new Cliente(123456789L, "ana.perez@gmail.com", "3012345678", "Ana Pérez", "Inactivo");
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        // Act
        Cliente nuevoCliente = clienteService.crearCliente(cliente);

        // Assert
        Assertions.assertThat(nuevoCliente).isNotNull();
    }

    @Test
    public void clienteServicioTest_findAll_ClienteList() {
        // Arrange
        when(clienteRepository.findAll()).thenReturn(
            List.of(
                new Cliente(123456789L, "ana.perez@gmail.com", "3012345678", "Ana Pérez", "Inactivo"),
                new Cliente(987654321L, "juan.perez@gmail.com", "3112347378", "Juan Pérez", "Inactivo")
                ));

        // Act
        List<Cliente> clientes = clienteService.SearchAll();

        // Assert
        Assertions.assertThat(clientes).isNotNull();
        Assertions.assertThat(clientes.size()).isEqualTo(2);
    }

    @Test
    public void clienteServicioTest_findById_Cliente() {
        // Arrange
        Cliente cliente = new Cliente(123456789L, "ana.perez@gmail.com", "3012345678", "Ana Pérez", "Inactivo");
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        // Act
        Cliente clienteEncontrado = clienteService.findById(1L);

        // Assert
        Assertions.assertThat(clienteEncontrado).isNotNull();
    }

    /*@Test
    public void clienteServicioTest_deleteCliente() {
        // Arrange
        Cliente cliente = new Cliente(123456789L, "ana.perez@gmail.com", "3012345678", "Ana Pérez", "Inactivo");
        doNothing().when(clienteRepository).deleteById(1L);

        // Act
        clienteService.delete(1L);

        // Assert
        verify(clienteRepository).deleteById(1L);
    }*/
}
