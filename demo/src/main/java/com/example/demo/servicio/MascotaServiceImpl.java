package com.example.demo.servicio;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Tratamiento;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.repositorio.TratamientoRepository;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    MascotaRepository mascotaRepositoryJPA;

    @Autowired
    ClienteRepository clienteRepositoryJPA;

    @Autowired
    TratamientoRepository tratamientoRepositoryJPA;

    @Override
    public Mascota SearchById(Long id) {
        return mascotaRepositoryJPA.findById(id).orElse(null);
    }

    @Override
    public List<Mascota> SearchAll() {
        return mascotaRepositoryJPA.findAll();
    }

    @Override
    public void deleteById(Long id) {
        Collection<Tratamiento> tratamientos = tratamientoRepositoryJPA.findByMascotaId(id);
        if (!tratamientos.isEmpty()) {
            for (Tratamiento tratamiento : tratamientos) {
                tratamiento.setMascota(null);
                tratamientoRepositoryJPA.save(tratamiento);
            }
        }
        mascotaRepositoryJPA.deleteById(id);
    }

    @Override
    public Mascota update(Mascota mascota) {
        // Vuelve a buscar la mascota original antes de ser editada para obtener la
        // cedula del dueño
        mascota.setCedulaDuenho(mascotaRepositoryJPA.findById(mascota.getId()).orElse(null).getCedulaDuenho());
        mascota.setCliente(mascotaRepositoryJPA.findById(mascota.getId()).orElse(null).getCliente());
        mascotaRepositoryJPA.save(mascota);
        Cliente cliente = mascota.getCliente();
        cliente.setEstado("Inactivo");
        for (int i = 0; i < cliente.getMascotas().size(); i++) {
            if (cliente.getMascotas().get(i).getEstado().equals("En tratamiento")) {
                System.out.println(cliente.getMascotas().get(i).getEstado());
                cliente.setEstado("Activo");
            }
        }
        clienteRepositoryJPA.save(cliente);

        return mascota;
    }

    @Override
    public Mascota save(Mascota mascota) {
        List<Cliente> clientes = clienteRepositoryJPA.findClienteByCedula(mascota.getCedulaDuenho());

        if (!clientes.isEmpty()) {
            Cliente cliente = clientes.get(0); // Obtener el primer cliente de la lista
            mascota.setCliente(cliente); // Asignar el cliente a la mascota
            mascotaRepositoryJPA.save(mascota);

            cliente.setEstado("Inactivo");
            for (int i = 0; i < cliente.getMascotas().size(); i++) {
                if (cliente.getMascotas().get(i).getEstado().equals("En tratamiento")) {
                    System.out.println(cliente.getMascotas().get(i).getEstado());
                    cliente.setEstado("Activo");
                }
            }
            clienteRepositoryJPA.save(cliente);

        } else {
            throw new RuntimeException("No se encontro el cliente con la cédula: " + mascota.getCedulaDuenho());
        }


        return mascota;
    }

    @Override
    public Collection<Mascota> findMascotaByNombre(String nombre) {
        return mascotaRepositoryJPA.findMascotaByNombre(nombre);
    }

    @Override
    public Collection<Mascota> findMascotaByRaza(String raza) {
        return mascotaRepositoryJPA.findMascotaByRaza(raza);
    }

    @Override
    public Collection<Mascota> findMascotaByEnfermedad(String enfermedad) {
        return mascotaRepositoryJPA.findMascotaByEnfermedad(enfermedad);
    }

    @Override
    public Collection<Mascota> findMascotaByEstado(String estado) {
        return mascotaRepositoryJPA.findMascotaByEstado(estado);
    }

    @Override
    public int getTotalMascotas() {
        // Obtiene la cantidad total de mascotas y la convierte a int
        return (int) mascotaRepositoryJPA.count(); // Cast a int desde long
    }

    @Override
    public int getTotalMascotasEnTratamiento() {
        return mascotaRepositoryJPA.countMascotasEnTratamiento(); // Llama al método del repositorio
    }
}
