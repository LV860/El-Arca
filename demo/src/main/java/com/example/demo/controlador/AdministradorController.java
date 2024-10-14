package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Administrador;
import com.example.demo.entidad.Cliente;
import com.example.demo.servicio.AdministradorService;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.VeterinarioService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdministradorController {

    @Autowired
    private AdministradorService admiService;


    /* 
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeterinarioService veterinarioService;
    */

    @GetMapping("/all")
    @Operation(summary = "Mostrar todas los clientes")
    public List<Administrador> listarClientes() {
        return admiService.SearchAll();
    }

    @GetMapping("/find/{id}")
    public Administrador mostrarInfoAdmi(@PathVariable("id") Long id) {
        return admiService.findById(id);
    }

    @GetMapping("/find/{usuario}")
    public Administrador mostrarInfoAdmi2(@PathVariable("usuario") String usuario) {
        return admiService.findByUsuario(usuario);
    }


}