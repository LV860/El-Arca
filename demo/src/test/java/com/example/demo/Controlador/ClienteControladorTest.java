package com.example.demo.Controlador;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.demo.controlador.ClienteController;
import com.example.demo.controlador.VeterinarioController;
import com.example.demo.entidad.Cliente;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.VeterinarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ClienteController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class ClienteControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @MockBean
    private VeterinarioService veterinarioService;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void ClienteController_agregarCliente_Cliente() throws Exception{
        Cliente cliente = new Cliente(
            123456789L,
            "ana.perez@gmail.com",
            "3012345678",
            "Ana Pérez",
            "Inactivo"
        );

        when(clienteService.save(Mockito.any(Cliente.class))).thenReturn(cliente);

        ResultActions response = mockMvc.perform(
            post("/clientes/add")
            .contentType("application/json")
            .content(mapper.writeValueAsString(cliente)

            )
        );

        response.andExpect(status().isCreated())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.cedula").value(cliente.getCedula()))
        .andExpect(jsonPath("$.correo").value(cliente.getCorreo()))
        .andExpect(jsonPath("$.celular").value(cliente.getCelular()))
        .andExpect(jsonPath("$.nombre").value(cliente.getNombre()))
        .andExpect(jsonPath("$.estado").value(cliente.getEstado()));
    }

    @Test
    public void ClienteController_SearchAll_CLienteList() throws Exception{

        when(clienteService.SearchAll()).thenReturn(
            List.of(
                new Cliente(
                    123456789L,
                    "ana.perez@gmail.com",
                    "3012345678",
                    "Ana Pérez",
                    "Inactivo"
                ),
                new Cliente(
                    987654321L,
                    "juan.perez@gmail.com",
                    "3112347378",
                    "Juan Pérez",
                    "Inactivo"
                )
            )
        );

        ResultActions response = mockMvc.perform(get("/clientes/all"));
        response.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.size()").value(2));

    }

    @Test
    public void ClienteController_findById_Cliente() throws Exception{
        when(clienteService.findById(anyLong())).thenReturn(
            null
        );

        ResultActions response = mockMvc.perform(
            
        get("/clientes/find/").param("id", "1")
        );

        response.andExpect(status().isNotFound());
    }
    
}
