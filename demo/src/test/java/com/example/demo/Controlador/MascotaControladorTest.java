package com.example.demo.Controlador;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

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

import com.example.demo.controlador.MascotaController;
import com.example.demo.entidad.Mascota;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.MascotaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = MascotaController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class MascotaControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MascotaService mascotaService;

    @MockBean
    private ClienteService clienteService;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void MascotaController_agregarMascota_Mascota() throws Exception{
        Mascota mascota = new Mascota(
            "Firulais",
            "Labrador",
            5,
            20.5,
            "Artritis",
            "https://example.com/firulais.jpg",
            123456789L,
            "En tratamiento"
        );

        when(mascotaService.save(Mockito.any(Mascota.class))).thenReturn(mascota);

        ResultActions response = mockMvc.perform(
            post("/mascota/add")
            .contentType("application/json")
            .content(mapper.writeValueAsString(mascota))
        );

        response.andExpect(status().isCreated())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.nombre").value(mascota.getNombre()))
        .andExpect(jsonPath("$.raza").value(mascota.getRaza()))
        .andExpect(jsonPath("$.edad").value(mascota.getEdad()))
        .andExpect(jsonPath("$.peso").value(mascota.getPeso()))
        .andExpect(jsonPath("$.enfermedad").value(mascota.getEnfermedad()))
        .andExpect(jsonPath("$.urlImagen").value(mascota.getUrlImagen()))
        .andExpect(jsonPath("$.cedulaDuenho").value(mascota.getCedulaDuenho()))
        .andExpect(jsonPath("$.estado").value(mascota.getEstado()));
    }

    @Test
    public void MascotaController_SearchAll_MascotaList() throws Exception{

        when(mascotaService.SearchAll()).thenReturn(
            List.of(
                new Mascota(
                    "Firulais",
                    "Labrador",
                    5,
                    20.5,
                    "Artritis",
                    "https://example.com/firulais.jpg",
                    123456789L,
                    "En tratamiento"
                ),
                new Mascota(
                    "Max",
                    "Beagle",
                    3,
                    12.5,
                    "Displasia",
                    "https://example.com/max.jpg",
                    987654321L,
                    "Inactivo"
                )
            )
        );

        ResultActions response = mockMvc.perform(get("/mascota/all"));
        response.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.size()").value(2));
    }

    @Test
    public void MascotaController_findById_Mascota() throws Exception{
        when(mascotaService.SearchById(anyLong())).thenReturn(null);

        ResultActions response = mockMvc.perform(
            get("/mascota/find/").param("id", "1")
        );

        response.andExpect(status().isNotFound());
    }
}
