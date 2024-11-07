package com.example.demo.controlador;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.VeterinarioDTO;
import com.example.demo.DTOs.VeterinarioMapper;
import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.UserEntity;
//import com.example.demo.entidad.Administrador;
//import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Veterinario;
import com.example.demo.repositorio.UserRepository;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.security.JWTGenerator;
//import com.example.demo.servicio.AdministradorService;
import com.example.demo.servicio.VeterinarioService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/veterinario")
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator jwtGenerator;

    @GetMapping("/all")
    @Operation(summary = "Mostrar todas los clientes")
    public List<Veterinario> listarVeterinario() {
        return veterinarioService.SearchAll();
    }

    @GetMapping("/details")
    public ResponseEntity<Veterinario> buscarVeterinario() {
        // Un usuario que llega ala url ya está autenticado
        Veterinario veterinario = veterinarioService.findByCedula(
                // guarda un objeto de autenticacion y este objeto tiene los datos
                // Puedo acceder a el desde cualquier lado de la aplicacion
                SecurityContextHolder.getContext().getAuthentication().getName());

        //VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(veterinario);

        if (veterinario == null) {
            return new ResponseEntity<Veterinario>(veterinario, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Veterinario>(veterinario, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public Veterinario mostrarInfoVeterinario(@PathVariable("id") Long id) {
        return veterinarioService.findById(id);
    }

    @GetMapping("/findCedula/{cedula}")
    public Veterinario findByCedula(@PathVariable("cedula") String cedula) {
        return veterinarioService.findByCedula(cedula);
    }

    @PostMapping("/add")
    public ResponseEntity agregarVeterinario(@RequestBody Veterinario veterinario) {
        /*
         * if (veterinario == null) {
         * return new ResponseEntity<String>("No se pudo agregar el veterinario",
         * HttpStatus.NOT_FOUND);
         * }
         * Veterinario newVeterinario = veterinarioService.save(veterinario);
         * VeterinarioDTO veterinarioDTO =
         * VeterinarioMapper.INSTANCE.convert(newVeterinario);
         * if (newVeterinario == null) {
         * return new ResponseEntity<VeterinarioDTO>(veterinarioDTO,
         * HttpStatus.BAD_REQUEST);
         * }
         * 
         * return new ResponseEntity<VeterinarioDTO>(veterinarioDTO,
         * HttpStatus.CREATED);
         */

        if (userRepository.existsByUsername(veterinario.getCedula())) {
            return new ResponseEntity<String>("El veterinario ya existe", HttpStatus.BAD_REQUEST);
        }
        UserEntity userEntity = customUserDetailService.VeterinarioToUser(veterinario);
        veterinario.setUserEntity(userEntity);
        Veterinario veterinarioDB = veterinarioService.save(veterinario);
        VeterinarioDTO newVeterinario = VeterinarioMapper.INSTANCE.convert(veterinarioDB);
        if (newVeterinario == null) {
            return new ResponseEntity<VeterinarioDTO>(newVeterinario, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<VeterinarioDTO>(newVeterinario, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity loginVeterinario(@RequestBody Veterinario veterinario) {

        /*
         * Veterinario vet = veterinarioService.findByCedula(veterinario.getCedula());
         * 
         * if (vet == null) {
         * return new ResponseEntity<String>("No se encontro el veterinario",
         * HttpStatus.NOT_FOUND);
         * }
         * 
         * VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(vet);
         * if (vet.getContrasena().equals(veterinario.getContrasena())) {
         * return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.OK);
         * } else {
         * return new ResponseEntity<VeterinarioDTO>(veterinarioDTO,
         * HttpStatus.BAD_REQUEST);
         * }
         */

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(veterinario.getCedula(), veterinario.getContrasena()));
        // tiene un atributo que es la autenticacion y es donde guardare la
        // autenticacion
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarCliente(@PathVariable("id") Long id) {
        veterinarioService.delete(id);
    }

    @PutMapping("/update/{id}")
    public void updateCliente(@RequestBody Veterinario veterinario) {

        // Logger logger = LoggerFactory.getLogger(ClienteController.class);
        // logger.info("cliente: " + cliente.getNombre());
        // System.out.println("cliente: " + cliente.getNombre());
        veterinarioService.update(veterinario);

    }
}
