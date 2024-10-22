package com.example.demo.Servicio;

import org.assertj.core.api.Assertions;
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

    @Test
    public void tratamientoServicioTest_crearTratamiento_Tratamiento(){

        //Arrange
        Veterinario veterinario = new Veterinario("11111111", "pass123", "Cirugía", "url1", "Dr. Pérez", "Activo");

        Mascota mascota1 = new Mascota("Firulais", "Labrador", 3, 30.5, "Ninguna", "urlImagen1", 123456789L, "Activo");
        Mascota mascota2 = new Mascota("Max", "Bulldog", 5, 25.0, "Alergias", "urlImagen2", 987654321L, "Activo");

        Droga droga = new Droga("Aspirina", 10.0f, 15.0f, 100, 50);
        
        Tratamiento tratamiento1 = new Tratamiento(50.0f, "2024-10-21", veterinario, mascota1, droga);
        Tratamiento tratamiento2 = new Tratamiento(75.0f, "2024-10-22", veterinario, mascota2, droga);
        
        //Act
        Tratamiento nuevoTratamiento = tratamientoService.crearTratamiento(tratamiento1);
        
        nuevoTratamiento = tratamientoService.crearTratamiento(tratamiento2);

        //Assert
        Assertions.assertThat(nuevoTratamiento).isNotNull();
    }

    @Test
    public void TratamientoService_findAll_TratamientoList(){
        //Arrange

        //Act
        List<Tratamiento> tratamientos = tratamientoService.findAll();


        //Assert
        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos.size()).isEqualTo(10);
    }

    
}
