package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Veterinario;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.VeterinarioService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping("/all")
    @Operation(summary = "Mostrar todas los clientes")
    public List<Cliente> listarClientes(Model model) {
        return clienteService.SearchAll();
    }

    @GetMapping("/findCedula/{cedula}")
    public Cliente findByCedula(@PathVariable("cedula") Long cedula){
        return clienteService.findByCedula(cedula);
    }

    @GetMapping("/find/{id}")
    public Cliente mostrarInfoCliente(@PathVariable("id") Long id) {
        return clienteService.findById(id);
    }

    @GetMapping("/find")
    public Cliente mostrarInfoCliente2(@RequestParam("id") Long id) {
        return clienteService.findById(id);
    }

    @GetMapping("/findVeterinario")
    public Veterinario buscarVeterinario(@RequestParam("id") Long id) {
        return veterinarioService.findById(id);
    }

    @GetMapping("/createClientes")
    public String mostrarFormularioCrearCliente(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "/createClientes";
    }

    @PostMapping("/add")
    public Cliente agregarCliente(@RequestBody Cliente cliente) {
        cliente.setEstado("Inactivo");
        clienteService.save(cliente);
        return cliente;
    }

    @DeleteMapping("/delete/{id}")
    public void borrarCliente(@PathVariable("id") Long id) {
        clienteService.delete(id);
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.findById(id));
        return "/updateClientes";
    }

    @PutMapping("/update/{id}")
    public void updateCliente(@RequestBody Cliente cliente) {
        // cliente.setCedula(id); // Asegura que el ID se mantenga al actualizar
        // cliente.setEstado(clienteService.findById(id).getEstado()); // Asegura que el
        // ID se mantenga al actualizar

        Logger logger = LoggerFactory.getLogger(ClienteController.class);

        logger.info("cliente: " + cliente.getNombre());
        System.out.println("cliente: " + cliente.getNombre());
        clienteService.update(cliente);

    }

    @GetMapping("/perfil")
    public List<Veterinario> perfilVeterinario(Model model) {
        return (List<Veterinario>) veterinarioService.SearchAll();
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
            // Manejar la excepción, por ejemplo, registrándola o mostrando un mensaje de
            // error
            System.err.println("Ocurrió un error: " + e.getMessage());
            model.addAttribute("error", "Ocurrió un error al intentar mostrar el perfil del veterinario.");
            return "/loginVeterinarioError";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus) {
        session.invalidate(); // Invalidate the session
        // Mostrar un mensaje de error si no se encuentra el veterinario
        return "redirect:/home/landingPage"; // Redirect to login page
    }

    @GetMapping("/search")
    // Manejar la excepción, por ejemplo, registrándola o mostrando un mensaje de
    // error
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

            case "inactivo":
                model.addAttribute("clientes", clienteService.findClienteByEstado("Inactivo"));
                return "veterinarioClientes";

            case "activo":
                model.addAttribute("clientes", clienteService.findClienteByEstado("Activo"));
                return "veterinarioClientes";

            default:
                model.addAttribute("clientes", clienteService.SearchAll());
                return "/veterinarioClientes";
        }
    }
}
