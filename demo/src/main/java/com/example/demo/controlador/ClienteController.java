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
    
    @GetMapping("/all")
    public String mostrarClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "html/tabla_Clientes";
    }
    
    @GetMapping("/añadir")
    public String mostrarFormularioAñadirCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "html/createClientes";
    }
    
    @PostMapping("/añadir")
    public String añadirCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes/all";
    }
    
    @GetMapping("/editar")
    public String mostrarFormularioEditarCliente(@RequestParam("cedula") String cedula, Model model) {
        Cliente cliente = clienteRepository.findByCedula(cedula);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "html/updateClientes";
        }
        return "redirect:/clientes/all"; 
    }
    
    @PostMapping("/editar")
    public String editarCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes/all";
    }
    
    @PostMapping("/eliminar")
    public String eliminarCliente(@RequestParam("cedula") String cedula) {
        clienteRepository.delete(cedula);
        return "redirect:/clientes/all";
    }
}
