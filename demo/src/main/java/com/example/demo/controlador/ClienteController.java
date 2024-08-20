package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entidad.Cliente;
import com.example.demo.repositorio.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "../html/veterinarioClientes"; 
    }

    @GetMapping("/añadir")
    public String mostrarFormularioAñadir(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "../html/createClientes"; 
    }
    @PostMapping("/añadir")
    public String añadirCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "../html/veterinarioClientes";
    }

    
    @GetMapping("/editar")
    public String mostrarFormularioEdicion(@RequestParam("id") String id, Model model) {

    Cliente cliente = clienteRepository.findByCedula(id);
    model.addAttribute("cliente", cliente);    
    return "../html/updateClientes"; 
}


    @PostMapping("/editar")
    public String actualizarCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "../html/veterinarioClientes"; 
    }

    @PostMapping("/eliminar")
    public String eliminarCliente(@RequestParam("id") String id) {
        clienteRepository.delete(id);
        return "../html/veterinarioClientes"; 
    }
}