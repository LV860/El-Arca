package com.example.demo.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Administrador;
import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Veterinario;
import com.example.demo.servicio.AdministradorService;
import com.example.demo.servicio.VeterinarioService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/veterinario")
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;


    @GetMapping("/all")
    @Operation(summary = "Mostrar todas los clientes")
    public List<Veterinario> listarVeterinario() {
        return veterinarioService.SearchAll();
    }


    @GetMapping("/find/{id}")
    public Veterinario mostrarInfoVeterinario(@PathVariable("id") Long id) {
        return veterinarioService.findById(id);
    }

    @GetMapping("/findCedula/{cedula}")
    public Veterinario findByCedula(@PathVariable("cedula") String cedula){
        return veterinarioService.findByCedula(cedula);
    }
    

    

    @PostMapping("/add")
    public void agregarCliente(@RequestBody Veterinario veterinario) {
        
        veterinarioService.save(veterinario);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarCliente(@PathVariable("id") Long id) {
        veterinarioService.delete(id);
    }


    @PutMapping("/update/{id}")
    public void updateCliente(@RequestBody Veterinario veterinario) {

        //Logger logger = LoggerFactory.getLogger(ClienteController.class);
        //logger.info("cliente: " + cliente.getNombre());
        //System.out.println("cliente: " + cliente.getNombre());
        veterinarioService.update(veterinario);

    }
}
