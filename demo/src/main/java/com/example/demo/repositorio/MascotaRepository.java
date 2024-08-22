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
        data.put(1, new Mascota(1,"Firulais", "Siberiano", 4, 30, "Cancer", "https://static.vecteezy.com/system/resources/thumbnails/008/951/892/small_2x/cute-puppy-pomeranian-mixed-breed-pekingese-dog-run-on-the-grass-with-happiness-photo.jpg"));
        data.put(2, new Mascota(2,"Rex", "Labrador", 3, 35, "Parvovirus", "https://cdn.pixabay.com/photo/2023/08/18/15/02/dog-8198719_640.jpg"));
        data.put(3, new Mascota(3,"Luna", "Bulldog", 5, 25, "Alérgico", "https://static.vecteezy.com/system/resources/thumbnails/005/857/332/small_2x/funny-portrait-of-cute-corgi-dog-outdoors-free-photo.jpg"));
        data.put(4, new Mascota(4,"Milo", "Beagle", 2, 20, "Tos de perrera", "https://www.nylabone.com/-/media/project/oneweb/nylabone/images/dog101/activities-fun/10-great-small-dog-breeds/maltese-portrait.jpg"));
        data.put(5, new Mascota(5,"Charlie", "Poodle", 1, 15, "Ninguna", "https://d3544la1u8djza.cloudfront.net/APHI/Blog/2021/07-06/small+white+fluffy+dog+smiling+at+the+camera+in+close-up-min.jpg"));
        data.put(6, new Mascota(6,"Max", "Chihuahua", 6, 5, "Hipoglucemia", "https://www.nylabone.com/-/media/project/oneweb/nylabone/images/dog101/10-intelligent-dog-breeds/golden-retriever-tongue-out.jpg"));
        data.put(7, new Mascota(7,"Bella", "Boxer", 4, 40, "Cardiomiopatía", "https://static.toiimg.com/photo/108245337/108245337.jpg"));
        data.put(8, new Mascota(8,"Rocky", "Dálmata", 7, 45, "Problemas de piel", "https://rukminim2.flixcart.com/image/850/1000/kzsqykw0/poster/f/v/f/small-cute-dog-poster-multicolour-photo-paper-print-pomeranian-original-imagbqa4gddkyggd.jpeg?q=90&crop=false"));
        data.put(9, new Mascota(9,"Daisy", "Pug", 5, 10, "Obesidad", "https://images.aeonmedia.co/images/acd6897d-9849-4188-92c6-79dabcbcd518/essay-final-gettyimages-685469924.jpg?width=3840&quality=75&format=auto"));
        data.put(10, new Mascota(10,"Sophie", "Yorkshire", 3, 7, "Leucemia", "https://i.natgeofe.com/n/4f5aaece-3300-41a4-b2a8-ed2708a0a27c/domestic-dog_thumb_3x2.jpg"));
    
    }

    public Mascota findById(int id){
        return data.get(id);
    }
    public Collection<Mascota> findAll(){
        return data.values();
    }

    //NUEVOS METODOS
    public void deleteById(int id){
        data.remove(id);
    }
    public void update(Mascota mascota){
        data.put(mascota.getId(), mascota);
    }
    public void add(Mascota mascota){
        int tam =data.size();
        int lastId = data.get(tam).getId();
        mascota.setId(lastId+1);
    }


    public void save(Mascota mascota) {
        data.put(mascota.getId(), mascota);
    }
}
