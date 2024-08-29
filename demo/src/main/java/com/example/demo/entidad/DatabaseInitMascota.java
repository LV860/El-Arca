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
        /* 
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
        */

        mascotaRepository.save(new Mascota("Rex", "Labrador", 4, 32.0, "Parvovirus", "https://example.com/labrador.jpg", "001"));
        mascotaRepository.save(new Mascota("Bella", "Beagle", 5, 15.0, "Otitis", "https://example.com/beagle.jpg", "002"));
        mascotaRepository.save(new Mascota("Charlie", "Bulldog", 3, 25.0, "Dermatitis", "https://example.com/bulldog.jpg", "003"));
        mascotaRepository.save(new Mascota("Lucy", "Poodle", 2, 10.0, "Enfermedad renal", "https://example.com/poodle.jpg", "004"));
        mascotaRepository.save(new Mascota("Max", "German Shepherd", 6, 35.0, "Displasia de cadera", "https://example.com/german_shepherd.jpg", "005"));
        mascotaRepository.save(new Mascota("Daisy", "Cocker Spaniel", 4, 14.0, "Alergias alimentarias", "https://example.com/cocker_spaniel.jpg", "006"));
        mascotaRepository.save(new Mascota("Milo", "Chihuahua", 3, 3.0, "Problemas dentales", "https://example.com/chihuahua.jpg", "007"));
        mascotaRepository.save(new Mascota("Luna", "Siberian Husky", 5, 28.0, "Hipo", "https://example.com/siberian_husky.jpg", "008"));
        mascotaRepository.save(new Mascota("Rocky", "Golden Retriever", 7, 30.0, "Epilepsia", "https://example.com/golden_retriever.jpg", "009"));
        mascotaRepository.save(new Mascota("Riley", "Dachshund", 4, 9.0, "Problemas en la columna", "https://example.com/dachshund.jpg", "010"));
        mascotaRepository.save(new Mascota("Zoe", "Yorkshire", 3, 4.0, "Leucemia", "https://example.com/yorkshire.jpg", "011"));
        mascotaRepository.save(new Mascota("Bailey", "Rottweiler", 6, 40.0, "Hip displasia", "https://example.com/rottweiler.jpg", "012"));
        mascotaRepository.save(new Mascota("Maggie", "Boxer", 5, 27.0, "Cardiopatía", "https://example.com/boxer.jpg", "013"));
        mascotaRepository.save(new Mascota("Oscar", "Pug", 4, 9.0, "Problemas respiratorios", "https://example.com/pug.jpg", "014"));
        mascotaRepository.save(new Mascota("Chloe", "Shih Tzu", 3, 6.0, "Cataratas", "https://example.com/shih_tzu.jpg", "015"));
        mascotaRepository.save(new Mascota("Jake", "Border Collie", 6, 22.0, "Enfermedad gastrointestinal", "https://example.com/border_collie.jpg", "016"));
        mascotaRepository.save(new Mascota("Mia", "Pomeranian", 2, 4.0, "Nerviosismo", "https://example.com/pomeranian.jpg", "017"));
        mascotaRepository.save(new Mascota("Jack", "Australian Shepherd", 4, 24.0, "Eczema", "https://example.com/australian_shepherd.jpg", "018"));
        mascotaRepository.save(new Mascota("Sophie", "French Bulldog", 5, 12.0, "Enfermedad cardíaca", "https://example.com/french_bulldog.jpg", "019"));
        mascotaRepository.save(new Mascota("Lola", "Great Dane", 6, 50.0, "Problemas de articulaciones", "https://example.com/great_dane.jpg", "020"));
        mascotaRepository.save(new Mascota("Teddy", "Boston Terrier", 3, 9.0, "Problemas de piel", "https://example.com/boston_terrier.jpg", "021"));
        mascotaRepository.save(new Mascota("Sam", "Dalmatian", 7, 27.0, "Alergia a los alimentos", "https://example.com/dalmatian.jpg", "022"));
        mascotaRepository.save(new Mascota("Ruby", "Havanese", 4, 8.0, "Cálculos renales", "https://example.com/havanese.jpg", "023"));
        mascotaRepository.save(new Mascota("Buddy", "Akita", 5, 33.0, "Problemas digestivos", "https://example.com/akita.jpg", "024"));
        mascotaRepository.save(new Mascota("Milo", "Maltese", 2, 4.5, "Problemas dentales", "https://example.com/maltese.jpg", "025"));
        mascotaRepository.save(new Mascota("Bella", "Bichon Frise", 3, 5.0, "Alergias", "https://example.com/bichon_frise.jpg", "026"));
        mascotaRepository.save(new Mascota("Charlie", "Pekingese", 6, 6.5, "Problemas respiratorios", "https://example.com/pekingese.jpg", "027"));
        mascotaRepository.save(new Mascota("Luna", "Saint Bernard", 5, 60.0, "Enfermedad cardíaca", "https://example.com/saint_bernard.jpg", "028"));
        mascotaRepository.save(new Mascota("Lucy", "Weimaraner", 4, 28.0, "Problemas óseos", "https://example.com/weimaraner.jpg", "029"));
        mascotaRepository.save(new Mascota("Rocky", "Schnauzer", 3, 12.0, "Cáncer", "https://example.com/schnauzer.jpg", "030"));
        mascotaRepository.save(new Mascota("Maggie", "Cavalier King Charles Spaniel", 4, 10.0, "Problemas de corazón", "https://example.com/cavalier_king_charles_spaniel.jpg", "031"));
        mascotaRepository.save(new Mascota("Oscar", "Irish Setter", 5, 28.0, "Alergias", "https://example.com/irish_setter.jpg", "032"));
        mascotaRepository.save(new Mascota("Daisy", "Papillon", 3, 5.0, "Problemas de piel", "https://example.com/papillon.jpg", "033"));
        mascotaRepository.save(new Mascota("Jack", "Chesapeake Bay Retriever", 4, 32.0, "Problemas de estómago", "https://example.com/chesapeake_bay_retriever.jpg", "034"));
        mascotaRepository.save(new Mascota("Zoe", "Old English Sheepdog", 5, 34.0, "Problemas de piel", "https://example.com/old_english_sheepdog.jpg", "035"));
        mascotaRepository.save(new Mascota("Toby", "Norwegian Elkhound", 6, 26.0, "Problemas articulares", "https://example.com/norwegian_elkhound.jpg", "036"));
        mascotaRepository.save(new Mascota("Sophie", "Lhasa Apso", 3, 7.0, "Cálculos urinarios", "https://example.com/lhasa_apso.jpg", "037"));
        mascotaRepository.save(new Mascota("Lola", "Whippet", 5, 15.0, "Problemas digestivos", "https://example.com/whippet.jpg", "038"));
        mascotaRepository.save(new Mascota("Teddy", "Puli", 6, 11.0, "Enfermedad renal", "https://example.com/puli.jpg", "039"));
        mascotaRepository.save(new Mascota("Mia", "Basenji", 2, 9.0, "Alergia alimentaria", "https://example.com/basenji.jpg", "040"));
        mascotaRepository.save(new Mascota("Chloe", "American Bulldog", 4, 35.0, "Problemas de cadera", "https://example.com/american_bulldog.jpg", "041"));
        mascotaRepository.save(new Mascota("Maggie", "Basset Hound", 7, 23.0, "Problemas respiratorios", "https://example.com/basset_hound.jpg", "042"));
        mascotaRepository.save(new Mascota("Oscar", "Hound", 3, 17.0, "Nerviosismo", "https://example.com/hound.jpg", "043"));
        mascotaRepository.save(new Mascota("Chloe", "French Bulldog", 4, 12.0, "Problemas gastrointestinales", "https://example.com/french_bulldog.jpg", "044"));
        mascotaRepository.save(new Mascota("Buddy", "Italian Greyhound", 5, 8.0, "Problemas en la piel", "https://example.com/italian_greyhound.jpg", "045"));
        mascotaRepository.save(new Mascota("Rocky", "Shetland Sheepdog", 6, 24.0, "Problemas articulares", "https://example.com/shetland_sheepdog.jpg", "046"));
        mascotaRepository.save(new Mascota("Riley", "Schnauzer", 4, 11.0, "Problemas dentales", "https://example.com/schnauzer.jpg", "047"));
        mascotaRepository.save(new Mascota("Luna", "Bull Terrier", 5, 30.0, "Cáncer", "https://example.com/bull_terrier.jpg", "048"));
        mascotaRepository.save(new Mascota("Zoe", "Jack Russell Terrier", 3, 6.0, "Problemas digestivos", "https://example.com/jack_russell_terrier.jpg", "049"));
        mascotaRepository.save(new Mascota("Mia", "Pekingese", 4, 9.0, "Cálculos renales", "https://example.com/pekingese.jpg", "050"));
        mascotaRepository.save(new Mascota("Sophie", "Australian Cattle Dog", 3, 22.0, "Problemas cardíacos", "https://example.com/australian_cattle_dog.jpg", "001"));
        mascotaRepository.save(new Mascota("Rocky", "Akita", 4, 33.0, "Problemas articulares", "https://example.com/akita.jpg", "002"));
        mascotaRepository.save(new Mascota("Charlie", "Labrador", 5, 30.0, "Enfermedad renal", "https://example.com/labrador.jpg", "003"));
        mascotaRepository.save(new Mascota("Daisy", "Shiba Inu", 6, 25.0, "Problemas respiratorios", "https://example.com/shiba_inu.jpg", "005"));
        mascotaRepository.save(new Mascota("Maggie", "Chihuahua", 2, 5.0, "Alergias", "https://example.com/chihuahua.jpg", "005"));
        mascotaRepository.save(new Mascota("Oscar", "Collie", 5, 27.0, "Problemas cardíacos", "https://example.com/collie.jpg", "006"));
        mascotaRepository.save(new Mascota("Riley", "Pomeranian", 3, 4.5, "Problemas de piel", "https://example.com/pomeranian.jpg", "007"));
        mascotaRepository.save(new Mascota("Zoe", "Boxer", 6, 29.0, "Problemas de estómago", "https://example.com/boxer.jpg", "008"));
        mascotaRepository.save(new Mascota("Luna", "Bichon Frise", 4, 7.0, "Enfermedad de piel", "https://example.com/bichon_frise.jpg", "009"));
        mascotaRepository.save(new Mascota("Jack", "Beagle", 5, 16.0, "Problemas dentales", "https://example.com/beagle.jpg", "010"));
        mascotaRepository.save(new Mascota("Toby", "Schnauzer", 6, 12.0, "Problemas articulares", "https://example.com/schnauzer.jpg", "011"));
        mascotaRepository.save(new Mascota("Chloe", "Dalmatian", 4, 22.0, "Problemas de piel", "https://example.com/dalmatian.jpg", "012"));
        mascotaRepository.save(new Mascota("Maggie", "Great Dane", 5, 55.0, "Problemas respiratorios", "https://example.com/great_dane.jpg", "013"));
        mascotaRepository.save(new Mascota("Riley", "Siberian Husky", 4, 30.0, "Hip displasia", "https://example.com/siberian_husky.jpg", "014"));
        mascotaRepository.save(new Mascota("Zoe", "French Bulldog", 6, 12.0, "Enfermedad cardíaca", "https://example.com/french_bulldog.jpg", "015"));
        mascotaRepository.save(new Mascota("Toby", "German Shepherd", 3, 34.0, "Displasia de cadera", "https://example.com/german_shepherd.jpg", "016"));
        mascotaRepository.save(new Mascota("Bella", "Cavalier King Charles Spaniel", 4, 14.0, "Alergias", "https://example.com/cavalier_king_charles_spaniel.jpg", "017"));
        mascotaRepository.save(new Mascota("Oscar", "Irish Setter", 5, 29.0, "Problemas digestivos", "https://example.com/irish_setter.jpg", "018"));
        mascotaRepository.save(new Mascota("Mia", "Australian Shepherd", 6, 25.0, "Enfermedad renal", "https://example.com/australian_shepherd.jpg", "019"));
        mascotaRepository.save(new Mascota("Rocky", "Pug", 4, 9.0, "Problemas respiratorios", "https://example.com/pug.jpg", "020"));
        mascotaRepository.save(new Mascota("Riley", "Pekingese", 2, 7.0, "Problemas dentales", "https://example.com/pekingese.jpg", "021"));
        mascotaRepository.save(new Mascota("Chloe", "Cocker Spaniel", 5, 12.0, "Problemas de piel", "https://example.com/cocker_spaniel.jpg", "022"));
        mascotaRepository.save(new Mascota("Sophie", "Akita", 6, 36.0, "Enfermedad cardíaca", "https://example.com/akita.jpg", "023"));
        mascotaRepository.save(new Mascota("Jack", "Boxer", 3, 30.0, "Alergias alimentarias", "https://example.com/boxer.jpg", "024"));
        mascotaRepository.save(new Mascota("Luna", "Chihuahua", 4, 5.0, "Problemas dentales", "https://example.com/chihuahua.jpg", "025"));
        mascotaRepository.save(new Mascota("Maggie", "Schnauzer", 6, 14.0, "Enfermedad renal", "https://example.com/schnauzer.jpg", "026"));
        mascotaRepository.save(new Mascota("Oscar", "Papillon", 3, 5.0, "Problemas digestivos", "https://example.com/papillon.jpg", "027"));
        mascotaRepository.save(new Mascota("Bella", "Poodle", 5, 11.0, "Cálculos renales", "https://example.com/poodle.jpg", "028"));
        mascotaRepository.save(new Mascota("Riley", "Great Dane", 6, 60.0, "Problemas articulares", "https://example.com/great_dane.jpg", "029"));
        mascotaRepository.save(new Mascota("Zoe", "Cavalier King Charles Spaniel", 4, 15.0, "Problemas cardíacos", "https://example.com/cavalier_king_charles_spaniel.jpg", "030"));
        mascotaRepository.save(new Mascota("Chloe", "Boston Terrier", 3, 9.0, "Problemas dentales", "https://example.com/boston_terrier.jpg", "031"));
        mascotaRepository.save(new Mascota("Mia", "Siberian Husky", 5, 28.0, "Problemas respiratorios", "https://example.com/siberian_husky.jpg", "032"));
        mascotaRepository.save(new Mascota("Rocky", "Beagle", 4, 16.0, "Enfermedad gastrointestinal", "https://example.com/beagle.jpg", "033"));
        mascotaRepository.save(new Mascota("Riley", "Shih Tzu", 6, 9.0, "Cálculos urinarios", "https://example.com/shih_tzu.jpg", "034"));
        mascotaRepository.save(new Mascota("Oscar", "Boxer", 3, 27.0, "Problemas cardíacos", "https://example.com/boxer.jpg", "035"));
        mascotaRepository.save(new Mascota("Luna", "Pomeranian", 4, 5.5, "Problemas digestivos", "https://example.com/pomeranian.jpg", "036"));
        mascotaRepository.save(new Mascota("Sophie", "Pekingese", 5, 9.0, "Problemas de piel", "https://example.com/pekingese.jpg", "037"));
        mascotaRepository.save(new Mascota("Jack", "Labrador", 6, 34.0, "Enfermedad renal", "https://example.com/labrador.jpg", "038"));
        mascotaRepository.save(new Mascota("Daisy", "Cocker Spaniel", 3, 15.0, "Problemas de piel", "https://example.com/cocker_spaniel.jpg", "039"));
        mascotaRepository.save(new Mascota("Chloe", "Maltese", 4, 4.0, "Problemas dentales", "https://example.com/maltese.jpg", "040"));
        mascotaRepository.save(new Mascota("Mia", "Dachshund", 5, 10.0, "Cálculos renales", "https://example.com/dachshund.jpg", "041"));
        mascotaRepository.save(new Mascota("Riley", "Yorkshire", 3, 6.0, "Enfermedad renal", "https://example.com/yorkshire.jpg", "042"));
        mascotaRepository.save(new Mascota("Oscar", "French Bulldog", 5, 12.0, "Problemas respiratorios", "https://example.com/french_bulldog.jpg", "043"));
        mascotaRepository.save(new Mascota("Sophie", "Shih Tzu", 4, 7.0, "Problemas digestivos", "https://example.com/shih_tzu.jpg", "044"));
        mascotaRepository.save(new Mascota("Luna", "Whippet", 6, 15.0, "Cálculos urinarios", "https://example.com/whippet.jpg", "045"));
        mascotaRepository.save(new Mascota("Rocky", "Havanese", 3, 8.0, "Enfermedad de piel", "https://example.com/havanese.jpg", "046"));
        mascotaRepository.save(new Mascota("Chloe", "Pekingese", 4, 9.0, "Alergias", "https://example.com/pekingese.jpg", "047"));
        mascotaRepository.save(new Mascota("Riley", "Boston Terrier", 5, 11.0, "Problemas respiratorios", "https://example.com/boston_terrier.jpg", "048"));
        mascotaRepository.save(new Mascota("Mia", "Shiba Inu", 3, 8.0, "Enfermedad renal", "https://example.com/shiba_inu.jpg", "049"));
        mascotaRepository.save(new Mascota("Jack", "Collie", 6, 25.0, "Problemas de piel", "https://example.com/collie.jpg", "050"));

    }

}

