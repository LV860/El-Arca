package com.example.demo.Servicio;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entidad.Droga;
import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Tratamiento;
import com.example.demo.entidad.Veterinario;
import com.example.demo.repositorio.TratamientoRepository;
import com.example.demo.servicio.DrogaService;
import com.example.demo.servicio.TratamientoService;
import com.example.demo.servicio.TratamientoServiceImpl;

import static org.mockito.Mockito.when;

import java.util.List;


@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class TratamientoServicioTestMock {

    @InjectMocks
    private TratamientoServiceImpl tratamientoService;

    @Mock
    TratamientoRepository tratamientoRepository;

    private Veterinario veterinario;
    private Mascota mascota1;
    private Mascota mascota2;
    private Droga droga;
    private Tratamiento tratamiento1;
    private Tratamiento tratamiento2;

    @BeforeEach
    public void setUp() {
        
    }

    @Test
    public void tratamientoServicioTest_crearTratamiento_Tratamiento() {
        //Arrange
        Tratamiento tratamiento = new Tratamiento(180.0f, "2024-09-15", veterinario, mascota1, droga);
        when(tratamientoRepository.save(tratamiento)).thenReturn(
            tratamiento
            );

        // Act
        Tratamiento nuevoTratamiento = tratamientoService.crearTratamiento(tratamiento);

        // Assert
        Assertions.assertThat(nuevoTratamiento).isNotNull();
    }

    @Test
    public void TratamientoService_findAll_TratamientoList() {
        //Arrange
        when(tratamientoRepository.findAll()).thenReturn(
            List.of(
                new Tratamiento(180.0f, "2024-09-15", veterinario, mascota1, droga),
                new Tratamiento(180.0f, "2024-09-30", veterinario, mascota1, droga)
            )
        );

        // Act
        List<Tratamiento> tratamientos = tratamientoService.findAll();

        // Assert
        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos.size()).isEqualTo(2);
    }

}
