package com.example.demo.Servicio;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entidad.Droga;
import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Tratamiento;
import com.example.demo.entidad.Veterinario;
import com.example.demo.servicio.DrogaService;
import com.example.demo.servicio.TratamientoService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TratamientoServicioTest {

    @Autowired
    private TratamientoService tratamientoService;

    private Veterinario veterinario;
    private Mascota mascota1;
    private Mascota mascota2;
    private Droga droga;
    private Tratamiento tratamiento1;
    private Tratamiento tratamiento2;

    @BeforeEach
    public void setUp() {
        veterinario = new Veterinario("11111111", "pass123", "Cirugía", "url1", "Dr. Pérez", "Activo");

        mascota1 = new Mascota("Firulais", "Labrador", 3, 30.5, "Ninguna", "urlImagen1", 123456789L, "Activo");
        mascota2 = new Mascota("Max", "Bulldog", 5, 25.0, "Alergias", "urlImagen2", 987654321L, "Activo");

        droga = new Droga("Aspirina", 10.0f, 15.0f, 100, 50);

        tratamiento1 = new Tratamiento(50.0f, "2024-10-21", veterinario, mascota1, droga);
        tratamiento2 = new Tratamiento(75.0f, "2024-10-22", veterinario, mascota2, droga);
    }

    @Test
    public void tratamientoServicioTest_crearTratamiento_Tratamiento() {
        // Act
        Tratamiento nuevoTratamiento1 = tratamientoService.crearTratamiento(tratamiento1);
        Tratamiento nuevoTratamiento2 = tratamientoService.crearTratamiento(tratamiento2);

        // Assert
        Assertions.assertThat(nuevoTratamiento1).isNotNull();
        Assertions.assertThat(nuevoTratamiento2).isNotNull();
    }

    @Test
    public void TratamientoService_findAll_TratamientoList() {
        // Act
        List<Tratamiento> tratamientos = tratamientoService.findAll();

        // Assert
        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos.size()).isEqualTo(10);
    }

}
