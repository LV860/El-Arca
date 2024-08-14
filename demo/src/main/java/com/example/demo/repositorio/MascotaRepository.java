package com.example.demo.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Mascota;

@Repository
public class MascotaRepository {

    private Map<Integer, Mascota> data = new HashMap<>();
    
    public MascotaRepository() {
        data.put(1, new Mascota("Firulais", "Siberiano", 4, 30, "Cancer", "https://static.vecteezy.com/system/resources/thumbnails/008/951/892/small_2x/cute-puppy-pomeranian-mixed-breed-pekingese-dog-run-on-the-grass-with-happiness-photo.jpg"));
        data.put(2, new Mascota("Rex", "Labrador", 3, 35, "Parvovirus", "https://static.vecteezy.com/system/resources/thumbnails/008/951/892/small_2x/cute-puppy-pomeranian-mixed-breed-pekingese-dog-run-on-the-grass-with-happiness-photo.jpg"));
        data.put(3, new Mascota("Luna", "Bulldog", 5, 25, "Alérgico", "https://static.vecteezy.com/system/resources/thumbnails/008/951/892/small_2x/cute-puppy-pomeranian-mixed-breed-pekingese-dog-run-on-the-grass-with-happiness-photo.jpg"));
        data.put(4, new Mascota("Milo", "Beagle", 2, 20, "Tos de perrera", "https://static.vecteezy.com/system/resources/thumbnails/008/951/892/small_2x/cute-puppy-pomeranian-mixed-breed-pekingese-dog-run-on-the-grass-with-happiness-photo.jpg"));
        data.put(5, new Mascota("Charlie", "Poodle", 1, 15, "Ninguna", "https://static.vecteezy.com/system/resources/thumbnails/008/951/892/small_2x/cute-puppy-pomeranian-mixed-breed-pekingese-dog-run-on-the-grass-with-happiness-photo.jpg"));
        data.put(6, new Mascota("Max", "Chihuahua", 6, 5, "Hipoglucemia", "https://static.vecteezy.com/system/resources/thumbnails/008/951/892/small_2x/cute-puppy-pomeranian-mixed-breed-pekingese-dog-run-on-the-grass-with-happiness-photo.jpg"));
        data.put(7, new Mascota("Bella", "Boxer", 4, 40, "Cardiomiopatía", "https://static.vecteezy.com/system/resources/thumbnails/008/951/892/small_2x/cute-puppy-pomeranian-mixed-breed-pekingese-dog-run-on-the-grass-with-happiness-photo.jpg"));
        data.put(8, new Mascota("Rocky", "Dálmata", 7, 45, "Problemas de piel", "https://static.vecteezy.com/system/resources/thumbnails/008/951/892/small_2x/cute-puppy-pomeranian-mixed-breed-pekingese-dog-run-on-the-grass-with-happiness-photo.jpg"));
        data.put(9, new Mascota("Daisy", "Pug", 5, 10, "Obesidad", "https://static.vecteezy.com/system/resources/thumbnails/008/951/892/small_2x/cute-puppy-pomeranian-mixed-breed-pekingese-dog-run-on-the-grass-with-happiness-photo.jpg"));
        data.put(10, new Mascota("Sophie", "Yorkshire", 3, 7, "Leucemia", "https://static.vecteezy.com/system/resources/thumbnails/008/951/892/small_2x/cute-puppy-pomeranian-mixed-breed-pekingese-dog-run-on-the-grass-with-happiness-photo.jpg"));
    
    }

    public Mascota findById(int id){
        return data.get(id);
    }
    public Collection<Mascota> findAll(){
        return data.values();
    }

    

}
