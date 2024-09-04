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
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Veterinario;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.VeterinarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeterinarioService veterinarioService;

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
    public String landingPage(HttpSession session, Model model) {
        Veterinario user = (Veterinario) session.getAttribute("veterinario");
        if (user != null) {
            model.addAttribute("veterinario", user);
            return "/perfilVeterinario";
        } else {
            // Handle the case where the user is not logged in
            model.addAttribute("error", "No estás autenticado.");
            return "/loginVeterinarioError";
        }
    }


    @PostMapping("/perfil")
    public String mostrarPerfil(@ModelAttribute Veterinario veterinario, HttpSession session, Model model) {
        try {
            Veterinario user = veterinarioService.findById(veterinario.getId());

            if (user != null) {
                session.setAttribute("veterinario", user); // Store in session
                
                model.addAttribute("veterinario", user);
                return "/perfilVeterinario";
            } else {
                model.addAttribute("error", "No se encontró el veterinario con los datos proporcionados.");
                return "/loginVeterinarioError";
            }
        } catch (Exception e) {
            // Manejar la excepción, por ejemplo, registrándola o mostrando un mensaje de error
            System.err.println("Ocurrió un error: " + e.getMessage());
            model.addAttribute("error", "Ocurrió un error al intentar mostrar el perfil del veterinario.");
            return "/loginVeterinarioError";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus) {
        session.invalidate(); // Invalidate the session
        return "redirect:/home/landingPage"; // Redirect to login page
    }


    @GetMapping("/search")
    public String searchClientes(@RequestParam("query") String query, 
                             @RequestParam("filterBy") String filterBy, 
                             Model model) {

    // Determine which filter to use
    switch (filterBy) {
        case "todos":
            model.addAttribute("clientes", clienteService.SearchAll());
            return "/veterinarioClientes"; 

        case "id":
            try {
                // Convert query to Long for ID search
                model.addAttribute("clientes", clienteService.findById(Long.parseLong(query)));
            } catch (NumberFormatException e) {
                // Handle invalid number format
                model.addAttribute("clientes", clienteService.SearchAll());
            }
            return "/veterinarioClientes"; 

        case "nombre":
            model.addAttribute("clientes", clienteService.findClienteByNombre(query));
            return "/veterinarioClientes"; 

        case "correo":
            model.addAttribute("clientes", clienteService.findClienteByCorreo(query));
            return "/veterinarioClientes"; 

        case "telefono":
            model.addAttribute("clientes", clienteService.findClienteByCelular(query));
            return "/veterinarioClientes"; 

        default:
            model.addAttribute("clientes", clienteService.SearchAll());
            return "/veterinarioClientes"; 
    }
}
}
