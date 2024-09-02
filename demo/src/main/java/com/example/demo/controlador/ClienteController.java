package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidad.Cliente;
import com.example.demo.servicio.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.SearchAll());
        return "/veterinarioClientes"; 
    }

     @GetMapping("/find/{id}")
    public String mostrarInfoCliente(Model model, @PathVariable("id") Long id) {
        model.addAttribute("cliente", clienteService.findById(id));
        return "/mostrarClientePage";
    }

    @GetMapping("/find")
    public String mostrarInfoCliente2(Model model, @RequestParam("id") Long id) {
        model.addAttribute("cliente", clienteService.findById(id));
        return "/mostrarClientePage";
    }

    @GetMapping("/createClientes")
    public String mostrarFormularioCrearCliente(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "/createClientes";
    }

    @PostMapping("/add")
    public String agregarCliente(@ModelAttribute Cliente cliente, Model model) {
        clienteService.save(cliente);
        model.addAttribute("clientes", clienteService.SearchAll());
        return "redirect:/clientes/all";
    }

    @GetMapping("/delete/{id}")
    public String borrarCliente(@PathVariable("id") Long id) {
        clienteService.delete(id);
        return "redirect:/clientes/all";
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.findById(id));
        return "/updateClientes";
    }

    @PostMapping("/update/{id}")
    public String updateCliente(@PathVariable("id") Long id, @ModelAttribute("cliente") Cliente cliente) {
        cliente.setCedula(id); // Asegura que el ID se mantenga al actualizar
        clienteService.update(cliente);
        return "redirect:/clientes/all";
    }

    @GetMapping("/perfil")
    public String landingPage() {
        return "/perfilVeterinario";
    }
}
