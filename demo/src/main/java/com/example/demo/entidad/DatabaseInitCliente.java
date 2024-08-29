package com.example.demo.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInitCliente implements ApplicationRunner {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        clienteRepository.save(new Cliente("12345", "juanchito@gmail.com", "3216547414", "Juan Andres Orjueña Bello"));
        clienteRepository.save(new Cliente("67890", "pipe@gmail.com", "3163597104", "Daniel Felipe Bello Navas"));

        clienteRepository.save(new Cliente("001", "ana.perez@gmail.com", "3012345678", "Ana Pérez"));
        clienteRepository.save(new Cliente("002", "juan.garcia@gmail.com", "3023456789", "Juan García"));
        clienteRepository.save(new Cliente("003", "maria.lopez@gmail.com", "3034567890", "María López"));
        clienteRepository.save(new Cliente("004", "pedro.martinez@gmail.com", "3045678901", "Pedro Martínez"));
        clienteRepository.save(new Cliente("005", "luisa.ramirez@gmail.com", "3056789012", "Luisa Ramírez"));
        clienteRepository.save(new Cliente("006", "carlos.gomez@gmail.com", "3067890123", "Carlos Gómez"));
        clienteRepository.save(new Cliente("007", "sofia.mora@gmail.com", "3078901234", "Sofía Mora"));
        clienteRepository.save(new Cliente("008", "david.herrera@gmail.com", "3089012345", "David Herrera"));
        clienteRepository.save(new Cliente("009", "natalia.mendoza@gmail.com", "3090123456", "Natalia Mendoza"));
        clienteRepository.save(new Cliente("010", "jorge.flores@gmail.com", "3101234567", "Jorge Flores"));
        clienteRepository.save(new Cliente("011", "valentina.ortiz@gmail.com", "3112345678", "Valentina Ortiz"));
        clienteRepository.save(new Cliente("012", "alvaro.castro@gmail.com", "3123456789", "Álvaro Castro"));
        clienteRepository.save(new Cliente("013", "laura.martinez@gmail.com", "3134567890", "Laura Martínez"));
        clienteRepository.save(new Cliente("014", "martin.cano@gmail.com", "3145678901", "Martín Cano"));
        clienteRepository.save(new Cliente("015", "carla.uribe@gmail.com", "3156789012", "Carla Uribe"));
        clienteRepository.save(new Cliente("016", "esteban.vera@gmail.com", "3167890123", "Esteban Vera"));
        clienteRepository.save(new Cliente("017", "camila.suarez@gmail.com", "3178901234", "Camila Suárez"));
        clienteRepository.save(new Cliente("018", "oscar.rodriqez@gmail.com", "3189012345", "Óscar Rodríguez"));
        clienteRepository.save(new Cliente("019", "juliana.valencia@gmail.com", "3190123456", "Juliana Valencia"));
        clienteRepository.save(new Cliente("020", "andres.carrillo@gmail.com", "3201234567", "Andrés Carrillo"));
        clienteRepository.save(new Cliente("021", "veronica.salazar@gmail.com", "3212345678", "Verónica Salazar"));
        clienteRepository.save(new Cliente("022", "gustavo.jimenez@gmail.com", "3223456789", "Gustavo Jiménez"));
        clienteRepository.save(new Cliente("023", "daniela.torres@gmail.com", "3234567890", "Daniela Torres"));
        clienteRepository.save(new Cliente("024", "sebastian.murillo@gmail.com", "3245678901", "Sebastián Murillo"));
        clienteRepository.save(new Cliente("025", "angela.romero@gmail.com", "3256789012", "Ángela Romero"));
        clienteRepository.save(new Cliente("026", "nicolas.pineda@gmail.com", "3267890123", "Nicolás Pineda"));
        clienteRepository.save(new Cliente("027", "martha.silva@gmail.com", "3278901234", "Martha Silva"));
        clienteRepository.save(new Cliente("028", "alexander.rios@gmail.com", "3289012345", "Alexander Ríos"));
        clienteRepository.save(new Cliente("029", "paola.garzon@gmail.com", "3290123456", "Paola Garzón"));
        clienteRepository.save(new Cliente("030", "jose.mendoza@gmail.com", "3301234567", "José Mendoza"));
        clienteRepository.save(new Cliente("031", "elena.moreno@gmail.com", "3312345678", "Elena Moreno"));
        clienteRepository.save(new Cliente("032", "samuel.estrella@gmail.com", "3323456789", "Samuel Estrella"));
        clienteRepository.save(new Cliente("033", "carolina.ortega@gmail.com", "3334567890", "Carolina Ortega"));
        clienteRepository.save(new Cliente("034", "javier.martinez@gmail.com", "3345678901", "Javier Martínez"));
        clienteRepository.save(new Cliente("035", "catalina.vargas@gmail.com", "3356789012", "Catalina Vargas"));
        clienteRepository.save(new Cliente("036", "martin.fernandez@gmail.com", "3367890123", "Martín Fernández"));
        clienteRepository.save(new Cliente("037", "isabella.castano@gmail.com", "3378901234", "Isabella Castaño"));
        clienteRepository.save(new Cliente("038", "manuel.palomino@gmail.com", "3389012345", "Manuel Palomino"));
        clienteRepository.save(new Cliente("039", "lina.quintero@gmail.com", "3390123456", "Lina Quintero"));
        clienteRepository.save(new Cliente("040", "santiago.garcia@gmail.com", "3401234567", "Santiago García"));
        clienteRepository.save(new Cliente("041", "silvia.morales@gmail.com", "3412345678", "Silvia Morales"));
        clienteRepository.save(new Cliente("042", "juanita.morales@gmail.com", "3423456789", "Juanita Morales"));
        clienteRepository.save(new Cliente("043", "fabian.garcia@gmail.com", "3434567890", "Fabian García"));
        clienteRepository.save(new Cliente("044", "maria.flores@gmail.com", "3445678901", "María Flores"));
        clienteRepository.save(new Cliente("045", "roberto.moreno@gmail.com", "3456789012", "Roberto Moreno"));
        clienteRepository.save(new Cliente("046", "valeria.perez@gmail.com", "3467890123", "Valeria Pérez"));
        clienteRepository.save(new Cliente("047", "raul.bermudez@gmail.com", "3478901234", "Raúl Bermúdez"));
        clienteRepository.save(new Cliente("048", "gloria.ramirez@gmail.com", "3489012345", "Gloria Ramírez"));
        clienteRepository.save(new Cliente("049", "andrea.carrillo@gmail.com", "3490123456", "Andrea Carrillo"));
        clienteRepository.save(new Cliente("050", "santiago.perez@gmail.com", "3501234567", "Santiago Pérez"));

        /* 
            mascotaRepository.save(new Mascota("Firulais", "Siberiano", 4, 30, "Cáncer", "https://static.vecteezy.com/system/resources/thumbnails/008/951/892/small_2x/cute-puppy-pomeranian-mixed-breed-pekingese-dog-run-on-the-grass-with-happiness-photo.jpg", "123456789"));
            mascotaRepository.save(new Mascota("Rex", "Labrador", 3, 35, "Parvovirus", "https://cdn.pixabay.com/photo/2023/08/18/15/02/dog-8198719_640.jpg", "0"));
        */
        Cliente asociar = clienteRepository.findById(1L).get();

        for(Mascota m : mascotaRepository.findAll()){
            m.setCliente(asociar);
            mascotaRepository.save(m);
        }
    }
    
}