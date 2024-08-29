package com.example.demo.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repositorio.MascotaRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInitMascota implements ApplicationRunner {

    @Autowired
    MascotaRepository mascotaRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        mascotaRepository.save(new Mascota("Firulais", "Siberiano", 4, 30, "Cáncer", "https://static.vecteezy.com/system/resources/thumbnails/008/951/892/small_2x/cute-puppy-pomeranian-mixed-breed-pekingese-dog-run-on-the-grass-with-happiness-photo.jpg", "123456789"));
        mascotaRepository.save(new Mascota("Rex", "Labrador", 3, 35, "Parvovirus", "https://cdn.pixabay.com/photo/2023/08/18/15/02/dog-8198719_640.jpg", "0"));
        mascotaRepository.save(new Mascota("Luna", "Bulldog", 5, 25, "Alérgico", "https://static.vecteezy.com/system/resources/thumbnails/005/857/332/small_2x/funny-portrait-of-cute-corgi-dog-outdoors-free-photo.jpg", "0"));
        mascotaRepository.save(new Mascota("Milo", "Beagle", 2, 20, "Tos de perrera", "https://www.nylabone.com/-/media/project/oneweb/nylabone/images/dog101/activities-fun/10-great-small-dog-breeds/maltese-portrait.jpg", "0"));
        mascotaRepository.save(new Mascota("Charlie", "Poodle", 1, 15, "Ninguna", "https://d3544la1u8djza.cloudfront.net/APHI/Blog/2021/07-06/small+white+fluffy+dog+smiling+at+the+camera+in+close-up-min.jpg", "0"));
        mascotaRepository.save(new Mascota("Max", "Chihuahua", 6, 5, "Hipoglucemia", "https://www.nylabone.com/-/media/project/oneweb/nylabone/images/dog101/10-intelligent-dog-breeds/golden-retriever-tongue-out.jpg", "0"));
        mascotaRepository.save(new Mascota("Bella", "Boxer", 4, 40, "Cardiomiopatía", "https://static.toiimg.com/photo/108245337/108245337.jpg", "0"));
        mascotaRepository.save(new Mascota("Rocky", "Dálmata", 7, 45, "Problemas de piel", "https://rukminim2.flixcart.com/image/850/1000/kzsqykw0/poster/f/v/f/small-cute-dog-poster-multicolour-photo-paper-print-pomeranian-original-imagbqa4gddkyggd.jpeg?q=90&crop=false", "0"));
        mascotaRepository.save(new Mascota("Daisy", "Pug", 5, 10, "Obesidad", "https://images.aeonmedia.co/images/acd6897d-9849-4188-92c6-79dabcbcd518/essay-final-gettyimages-685469924.jpg?width=3840&quality=75&format=auto", "0"));
        mascotaRepository.save(new Mascota("Sophie", "Yorkshire", 3, 7, "Leucemia", "https://i.natgeofe.com/n/4f5aaece-3300-41a4-b2a8-ed2708a0a27c/domestic-dog_thumb_3x2.jpg", "123456789"));

    }

}

