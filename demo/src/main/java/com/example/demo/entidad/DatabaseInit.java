package com.example.demo.entidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.repositorio.VeterinarioRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    VeterinarioRepository veterinarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {




        veterinarioRepository.save(new Veterinario("678901239", "abc", "Cirugia", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkWse0lHkT7VVmFQpPUZafYrfj-FrrbV7wGg&s",4,"Hugh Jackman"));
        
        

        clienteRepository.save(new Cliente(123456789L, "ana.perez@gmail.com", "3012345678", "Ana Pérez", "Inactivo"));
        clienteRepository.save(new Cliente(987654321L, "juan.garcia@gmail.com", "3023456789", "Juan García", "Activo"));
        clienteRepository.save(new Cliente(102345678L, "maria.lopez@gmail.com", "3034567890", "María López", "Activo"));
        clienteRepository.save(new Cliente(234567890L, "pedro.martinez@gmail.com", "3045678901", "Pedro Martínez", "Activo"));
        clienteRepository.save(new Cliente(345678901L, "luisa.ramirez@gmail.com", "3056789012", "Luisa Ramírez", "Activo"));
        clienteRepository.save(new Cliente(456789012L, "carlos.gomez@gmail.com", "3067890123", "Carlos Gómez", "Inactivo"));
        clienteRepository.save(new Cliente(567890123L, "sofia.mora@gmail.com", "3078901234", "Sofía Mora", "Activo"));
        clienteRepository.save(new Cliente(678901234L, "david.herrera@gmail.com", "3089012345", "David Herrera", "Activo"));
        clienteRepository.save(new Cliente(789012345L, "natalia.mendoza@gmail.com", "3090123456", "Natalia Mendoza", "Activo"));
        clienteRepository.save(new Cliente(890123456L, "jorge.flores@gmail.com", "3101234567", "Jorge Flores", "Activo"));
        clienteRepository.save(new Cliente(901234567L, "valentina.ortiz@gmail.com", "3112345678", "Valentina Ortiz", "Activo"));
        clienteRepository.save(new Cliente(234567891L, "alvaro.castro@gmail.com", "3123456789", "Álvaro Castro", "Activo"));
        clienteRepository.save(new Cliente(345678902L, "laura.martinez@gmail.com", "3134567890", "Laura Martínez", "Activo"));
        clienteRepository.save(new Cliente(456789013L, "martin.cano@gmail.com", "3145678901", "Martín Cano", "Activo"));
        clienteRepository.save(new Cliente(567890124L, "carla.uribe@gmail.com", "3156789012", "Carla Uribe", "Activo"));
        clienteRepository.save(new Cliente(678901235L, "esteban.vera@gmail.com", "3167890123", "Esteban Vera", "Inactivo"));
        clienteRepository.save(new Cliente(789012346L, "camila.suarez@gmail.com", "3178901234", "Camila Suárez", "Activo"));
        clienteRepository.save(new Cliente(890123457L, "oscar.rodriqez@gmail.com", "3189012345", "Óscar Rodríguez", "Inactivo"));
        clienteRepository.save(new Cliente(901234568L, "juliana.valencia@gmail.com", "3190123456", "Juliana Valencia", "Activo"));
        clienteRepository.save(new Cliente(234567892L, "andres.carrillo@gmail.com", "3201234567", "Andrés Carrillo", "Activo"));
        clienteRepository.save(new Cliente(345678903L, "veronica.salazar@gmail.com", "3212345678", "Verónica Salazar", "Activo"));
        clienteRepository.save(new Cliente(456789014L, "gustavo.jimenez@gmail.com", "3223456789", "Gustavo Jiménez", "Inactivo"));
        clienteRepository.save(new Cliente(567890125L, "daniela.torres@gmail.com", "3234567890", "Daniela Torres", "Activo"));
        clienteRepository.save(new Cliente(678901236L, "sebastian.murillo@gmail.com", "3245678901", "Sebastián Murillo", "Activo"));
        clienteRepository.save(new Cliente(789012347L, "angela.romero@gmail.com", "3256789012", "Ángela Romero", "Inactivo"));
        clienteRepository.save(new Cliente(890123458L, "nicolas.pineda@gmail.com", "3267890123", "Nicolás Pineda", "Activo"));
        clienteRepository.save(new Cliente(901234569L, "martha.silva@gmail.com", "3278901234", "Martha Silva", "Activo"));
        clienteRepository.save(new Cliente(102345680L, "alexander.rios@gmail.com", "3289012345", "Alexander Ríos", "Activo"));
        clienteRepository.save(new Cliente(234567893L, "paola.garzon@gmail.com", "3290123456", "Paola Garzón", "Activo"));
        clienteRepository.save(new Cliente(345678904L, "jose.mendoza@gmail.com", "3301234567", "José Mendoza", "Activo"));
        clienteRepository.save(new Cliente(456789015L, "elena.moreno@gmail.com", "3312345678", "Elena Moreno", "Activo"));
        clienteRepository.save(new Cliente(567890126L, "samuel.estrella@gmail.com", "3323456789", "Samuel Estrella", "Activo"));
        clienteRepository.save(new Cliente(678901237L, "carolina.ortega@gmail.com", "3334567890", "Carolina Ortega", "Activo"));
        clienteRepository.save(new Cliente(789012348L, "javier.martinez@gmail.com", "3345678901", "Javier Martínez", "Activo"));
        clienteRepository.save(new Cliente(890123459L, "catalina.vargas@gmail.com", "3356789012", "Catalina Vargas", "Inactivo"));
        clienteRepository.save(new Cliente(901234570L, "martin.fernandez@gmail.com", "3367890123", "Martín Fernández", "Inactivo"));
        clienteRepository.save(new Cliente(102345681L, "isabella.castano@gmail.com", "3378901234", "Isabella Castaño", "Inactivo"));
        clienteRepository.save(new Cliente(234567894L, "manuel.palomino@gmail.com", "3389012345", "Manuel Palomino", "Inactivo"));
        clienteRepository.save(new Cliente(345678905L, "lina.quintero@gmail.com", "3390123456", "Lina Quintero", "Activo"));
        clienteRepository.save(new Cliente(456789016L, "santiago.garcia@gmail.com", "3401234567", "Santiago García", "Activo"));
        clienteRepository.save(new Cliente(567890127L, "silvia.morales@gmail.com", "3412345678", "Silvia Morales", "Activo"));
        clienteRepository.save(new Cliente(678901238L, "juanita.morales@gmail.com", "3423456789", "Juanita Morales", "Activo"));
        clienteRepository.save(new Cliente(789012349L, "fabian.garcia@gmail.com", "3434567890", "Fabian García", "Activo"));
        clienteRepository.save(new Cliente(890123460L, "maria.flores@gmail.com", "3445678901", "María Flores", "Activo"));
        clienteRepository.save(new Cliente(901234571L, "roberto.moreno@gmail.com", "3456789012", "Roberto Moreno", "Activo"));
        clienteRepository.save(new Cliente(102345682L, "valeria.perez@gmail.com", "3467890123", "Valeria Pérez", "Inactivo"));
        clienteRepository.save(new Cliente(234567895L, "raul.bermudez@gmail.com", "3478901234", "Raúl Bermúdez", "Activo"));
        clienteRepository.save(new Cliente(345678906L, "gloria.ramirez@gmail.com", "3489012345", "Gloria Ramírez", "Activo"));
        clienteRepository.save(new Cliente(456789017L, "andrea.carrillo@gmail.com", "3490123456", "Andrea Carrillo", "Inactivo"));
        clienteRepository.save(new Cliente(567890128L, "santiago.perez@gmail.com", "3501234567", "Santiago Pérez", "Inactivo"));


        
        mascotaRepository.save(new Mascota("Rex", "Labrador", 4, 32.0, "", "https://dogtime.com/wp-content/uploads/sites/12/2024/01/GettyImages-590608307.jpg?resize=1200,630", 123456789L, "Inactiva"));
        mascotaRepository.save(new Mascota("Bella", "Beagle", 5, 15.0, "Otitis", "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", 987654321L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Charlie", "Bulldog", 3, 25.0, "Dermatitis", "https://www.ngenespanol.com/wp-content/uploads/2022/08/estudio-ayuda-a-conocer-origen-de-los-perros-1280x720.jpg", 102345678L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Lucy", "Poodle", 2, 10.0, "Enfermedad renal", "https://s1.elespanol.com/2022/04/05/actualidad/662693884_223269248_1024x576.jpg", 234567890L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Max", "German Shepherd", 6, 35.0, "Displasia de cadera", "https://dogtime.com/wp-content/uploads/sites/12/2024/01/GettyImages-590608307.jpg?resize=1200,630", 345678901L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Daisy", "Cocker Spaniel", 4, 14.0, "", "https://s3.abcstatics.com/media/familia/2022/04/06/perrook-k0o--1248x698@abc.jpg", 456789012L, "Inactiva"));
        mascotaRepository.save(new Mascota("Milo", "Chihuahua", 3, 3.0, "Problemas dentales", "https://images.ctfassets.net/550nf1gumh01/1JK6iiirhoZG3RtyKZDrS7/c7f3eca5c3fdfd9a94143301fe5669a3/iStock-1313232209.jpg?q=90&w=1240", 567890123L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Luna", "Siberian Husky", 5, 28.0, "Hipo", "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", 678901234L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Rocky", "Golden Retriever", 7, 30.0, "Epilepsia", "https://s1.elespanol.com/2022/04/05/actualidad/662693884_223269248_1024x576.jpg", 789012345L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Riley", "Dachshund", 4, 9.0, "Problemas en la columna", "https://www.abc.es/xlsemanal/wp-content/uploads/sites/5/2024/04/estudio-cerebro-perros-parecido-humanos-reconocer-palabras-a.jpg", 890123456L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Zoe", "Yorkshire", 3, 4.0, "Leucemia", "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", 901234567L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Bailey", "Rottweiler", 6, 40.0, "Hip displasia", "https://s3.abcstatics.com/media/familia/2022/04/06/perrook-k0o--1248x698@abc.jpg", 234567891L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Maggie", "Boxer", 5, 27.0, "Cardiopatía", "https://dogtime.com/wp-content/uploads/sites/12/2024/01/GettyImages-590608307.jpg?resize=1200,630", 345678902L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Oscar", "Pug", 4, 9.0, "Problemas respiratorios", "https://www.ngenespanol.com/wp-content/uploads/2022/08/estudio-ayuda-a-conocer-origen-de-los-perros-1280x720.jpg", 456789013L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Chloe", "Shih Tzu", 3, 6.0, "Cataratas", "https://s1.elespanol.com/2022/04/05/actualidad/662693884_223269248_1024x576.jpg", 567890124L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Jake", "Border Collie", 6, 22.0, "Enfermedad gastrointestinal", "https://s3.abcstatics.com/media/familia/2022/04/06/perrook-k0o--1248x698@abc.jpg", 678901235L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Mia", "Pomeranian", 2, 4.0, "Nerviosismo", "https://dogtime.com/wp-content/uploads/sites/12/2024/01/GettyImages-590608307.jpg?resize=1200,630", 789012346L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Jack", "Australian Shepherd", 4, 24.0, "Eczema", "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", 890123457L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Sophie", "French Bulldog", 5, 12.0, "Enfermedad cardíaca", "https://georgiainjurylawyer.com/wp-content/uploads/2022/11/pitbull.jpg", 901234568L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Lola", "Great Dane", 6, 50.0, "Problemas de articulaciones", "https://adiestrar-perros.com/wp-content/uploads/2021/08/gran-danes-en-el-campo.jpg", 234567892L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Teddy", "Boston Terrier", 3, 9.0, "Problemas de piel", "https://s1.elespanol.com/2022/04/05/actualidad/662693884_223269248_1024x576.jpg", 345678903L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Sam", "Dalmatian", 7, 27.0, "Alergia a los alimentos", "https://www.abc.es/xlsemanal/wp-content/uploads/sites/5/2024/04/estudio-cerebro-perros-parecido-humanos-reconocer-palabras-a.jpg", 456789014L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Ruby", "Havanese", 4, 8.0, "Cálculos renales", "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", 567890125L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Buddy", "Akita", 5, 33.0, "Problemas digestivos", "https://www.ngenespanol.com/wp-content/uploads/2022/08/estudio-ayuda-a-conocer-origen-de-los-perros-1280x720.jpg", 678901236L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Milo", "Maltese", 2, 4.5, "", "https://s1.elespanol.com/2022/04/05/actualidad/662693884_223269248_1024x576.jpg", 789012347L, "Inactiva"));
        mascotaRepository.save(new Mascota("Bella", "Bichon Frise", 3, 5.0, "Alergias", "https://www.abc.es/xlsemanal/wp-content/uploads/sites/5/2024/04/estudio-cerebro-perros-parecido-humanos-reconocer-palabras-a.jpg", 890123458L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Charlie", "Pekingese", 6, 6.5, "Problemas respiratorios", "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", 901234569L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Luna", "Saint Bernard", 5, 60.0, "Enfermedad cardíaca", "https://dogtime.com/wp-content/uploads/sites/12/2024/01/GettyImages-590608307.jpg?resize=1200,630", 102345680L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Lucy", "Weimaraner", 4, 28.0, "Problemas óseos", "https://georgiainjurylawyer.com/wp-content/uploads/2022/11/pitbull.jpg", 234567893L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Rocky", "Schnauzer", 3, 12.0, "Cáncer", "https://www.ngenespanol.com/wp-content/uploads/2022/08/estudio-ayuda-a-conocer-origen-de-los-perros-1280x720.jpg", 345678904L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Maggie", "Cavalier King Charles Spaniel", 4, 10.0, "Problemas de corazón", "https://www.abc.es/xlsemanal/wp-content/uploads/sites/5/2024/04/estudio-cerebro-perros-parecido-humanos-reconocer-palabras-a.jpg", 456789015L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Oscar", "Irish Setter", 5, 28.0, "Alergias", "https://s3.abcstatics.com/media/familia/2022/04/06/perrook-k0o--1248x698@abc.jpg", 567890126L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Daisy", "Papillon", 3, 5.0, "Problemas de piel", "https://dogtime.com/wp-content/uploads/sites/12/2024/01/GettyImages-590608307.jpg?resize=1200,630", 678901237L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Jack", "Chesapeake Bay Retriever", 4, 32.0, "Problemas de estómago", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7c/Chesapeake_Bay_Retriever1.jpg/800px-Chesapeake_Bay_Retriever1.jpg", 789012348L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Zoe", "Old English Sheepdog", 5, 34.0, "Problemas de piel", "https://www.abc.es/xlsemanal/wp-content/uploads/sites/5/2024/04/estudio-cerebro-perros-parecido-humanos-reconocer-palabras-a.jpg", 890123459L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Toby", "Norwegian Elkhound", 6, 26.0, "Problemas articulares", "https://georgiainjurylawyer.com/wp-content/uploads/2022/11/pitbull.jpg", 901234570L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Sophie", "Lhasa Apso", 3, 7.0, "Cálculos urinarios", "https://www.ngenespanol.com/wp-content/uploads/2022/08/estudio-ayuda-a-conocer-origen-de-los-perros-1280x720.jpg", 102345681L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Lola", "Whippet", 5, 15.0, "Problemas digestivos", "https://s1.elespanol.com/2022/04/05/actualidad/662693884_223269248_1024x576.jpg", 234567894L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Teddy", "Puli", 6, 11.0, "Enfermedad renal", "https://dogtime.com/wp-content/uploads/sites/12/2024/01/GettyImages-590608307.jpg?resize=1200,630", 345678905L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Mia", "Basenji", 2, 9.0, "Alergia alimentaria", "https://www.thesprucepets.com/thmb/OesXBEbQ66yLpy_ciEGcA6Nh9ME=/2123x0/filters:no_upscale():strip_icc()/2.PhotographsbyMariaitinaBasenji-d728578d5f81415cb8fe799149d49489.jpg", 456789016L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Chloe", "American Bulldog", 4, 35.0, "Problemas de cadera", "https://www.ngenespanol.com/wp-content/uploads/2022/08/estudio-ayuda-a-conocer-origen-de-los-perros-1280x720.jpg", 567890127L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Maggie", "Basset Hound", 7, 23.0, "Problemas respiratorios", "https://s3.abcstatics.com/media/familia/2022/04/06/perrook-k0o--1248x698@abc.jpg", 678901238L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Oscar", "Hound", 3, 17.0, "Nerviosismo", "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", 789012349L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Chloe", "French Bulldog", 4, 12.0, "Problemas gastrointestinales", "https://www.abc.es/xlsemanal/wp-content/uploads/sites/5/2024/04/estudio-cerebro-perros-parecido-humanos-reconocer-palabras-a.jpg", 890123460L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Buddy", "Italian Greyhound", 5, 8.0, "Problemas en la piel", "https://s1.elespanol.com/2022/04/05/actualidad/662693884_223269248_1024x576.jpg", 901234571L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Rocky", "Shetland Sheepdog", 6, 24.0, "Problemas articulares", "https://georgiainjurylawyer.com/wp-content/uploads/2022/11/pitbull.jpg", 102345682L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Riley", "Schnauzer", 4, 11.0, "Problemas dentales", "https://www.abc.es/xlsemanal/wp-content/uploads/sites/5/2024/04/estudio-cerebro-perros-parecido-humanos-reconocer-palabras-a.jpg", 234567895L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Luna", "Bull Terrier", 5, 30.0, "Cáncer", "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", 345678906L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Zoe", "Jack Russell Terrier", 3, 6.0, "Problemas digestivos", "https://www.abc.es/xlsemanal/wp-content/uploads/sites/5/2024/04/estudio-cerebro-perros-parecido-humanos-reconocer-palabras-a.jpg", 456789017L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Mia", "Pekingese", 4, 9.0, "Cálculos renales", "https://www.ngenespanol.com/wp-content/uploads/2022/08/estudio-ayuda-a-conocer-origen-de-los-perros-1280x720.jpg", 567890128L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Sophie", "Australian Cattle Dog", 3, 22.0, "Problemas cardíacos", "https://as2.ftcdn.net/v2/jpg/00/45/24/35/1000_F_45243551_VzCoEIqsbrDUtJ5d7tjdOnbO9CLZlpk7.jpg", 123456789L, "Inactiva"));
        mascotaRepository.save(new Mascota("Rocky", "Akita", 4, 33.0, "Problemas articulares", "https://dogtime.com/wp-content/uploads/sites/12/2024/01/GettyImages-590608307.jpg?resize=1200,630", 987654321L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Charlie", "Labrador", 5, 30.0, "Enfermedad renal", "https://s1.elespanol.com/2022/04/05/actualidad/662693884_223269248_1024x576.jpg", 102345678L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Daisy", "Shiba Inu", 6, 25.0, "Problemas respiratorios", "https://www.abc.es/xlsemanal/wp-content/uploads/sites/5/2024/04/estudio-cerebro-perros-parecido-humanos-reconocer-palabras-a.jpg", 234567890L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Maggie", "Chihuahua", 2, 5.0, "Alergias", "https://example.com/chihuahua.jpg", 345678901L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Oscar", "Collie", 5, 27.0, "Problemas cardíacos", "https://georgiainjurylawyer.com/wp-content/uploads/2022/11/pitbull.jpg", 456789012L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Riley", "Pomeranian", 3, 4.5, "Problemas de piel", "https://www.lavanguardia.com/files/og_thumbnail/files/fp/uploads/2023/08/11/64d616bc0ed58.r_d.3943-2629-1521.jpeg", 567890123L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Zoe", "Boxer", 6, 29.0, "Problemas de estómago", "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", 678901234L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Luna", "Bichon Frise", 4, 7.0, "Enfermedad de piel", "https://s1.elespanol.com/2022/04/05/actualidad/662693884_223269248_1024x576.jpg", 789012345L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Jack", "Beagle", 5, 16.0, "Problemas dentales", "https://www.ngenespanol.com/wp-content/uploads/2022/08/estudio-ayuda-a-conocer-origen-de-los-perros-1280x720.jpg", 890123456L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Toby", "Schnauzer", 6, 12.0, "Problemas articulares", "https://www.abc.es/xlsemanal/wp-content/uploads/sites/5/2024/04/estudio-cerebro-perros-parecido-humanos-reconocer-palabras-a.jpg", 901234567L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Chloe", "Dalmatian", 4, 22.0, "Problemas de piel", "https://dogtime.com/wp-content/uploads/sites/12/2024/01/GettyImages-590608307.jpg?resize=1200,630", 234567891L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Maggie", "Great Dane", 5, 55.0, "Problemas respiratorios", "https://georgiainjurylawyer.com/wp-content/uploads/2022/11/pitbull.jpg", 345678902L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Riley", "Siberian Husky", 4, 30.0, "Hip displasia", "https://www.lavanguardia.com/files/og_thumbnail/files/fp/uploads/2023/08/11/64d616bc0ed58.r_d.3943-2629-1521.jpeg", 456789013L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Zoe", "French Bulldog", 6, 12.0, "Enfermedad cardíaca", "https://www.ngenespanol.com/wp-content/uploads/2022/08/estudio-ayuda-a-conocer-origen-de-los-perros-1280x720.jpg", 567890124L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Toby", "German Shepherd", 3, 34.0, "", "https://s1.elespanol.com/2022/04/05/actualidad/662693884_223269248_1024x576.jpg", 678901235L, "Inactiva"));
        mascotaRepository.save(new Mascota("Bella", "Cavalier King Charles Spaniel", 4, 14.0, "Alergias", "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", 789012346L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Oscar", "Irish Setter", 5, 29.0, "", "https://www.lavanguardia.com/files/og_thumbnail/files/fp/uploads/2023/08/11/64d616bc0ed58.r_d.3943-2629-1521.jpeg", 890123457L, "Inactiva"));
        mascotaRepository.save(new Mascota("Mia", "Australian Shepherd", 6, 25.0, "Enfermedad renal", "https://s3.abcstatics.com/media/familia/2022/04/06/perrook-k0o--1248x698@abc.jpg", 901234568L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Rocky", "Pug", 4, 9.0, "Problemas respiratorios", "https://s3.abcstatics.com/media/familia/2022/04/06/perrook-k0o--1248x698@abc.jpg", 234567892L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Riley", "Pekingese", 2, 7.0, "Problemas dentales", "https://georgiainjurylawyer.com/wp-content/uploads/2022/11/pitbull.jpg", 345678903L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Chloe", "Cocker Spaniel", 5, 12.0, "", "https://s1.elespanol.com/2022/04/05/actualidad/662693884_223269248_1024x576.jpg", 456789014L, "Inactiva"));
        mascotaRepository.save(new Mascota("Sophie", "Akita", 6, 36.0, "Enfermedad cardíaca", "https://dogtime.com/wp-content/uploads/sites/12/2024/01/GettyImages-590608307.jpg?resize=1200,630", 567890125L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Jack", "Boxer", 3, 30.0, "Alergias alimentarias", "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", 678901236L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Luna", "Chihuahua", 4, 5.0, "Problemas dentales", "https://www.ngenespanol.com/wp-content/uploads/2022/08/estudio-ayuda-a-conocer-origen-de-los-perros-1280x720.jpg", 789012347L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Maggie", "Schnauzer", 6, 14.0, "Enfermedad renal", "https://s3.abcstatics.com/media/familia/2022/04/06/perrook-k0o--1248x698@abc.jpg", 890123458L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Oscar", "Papillon", 3, 5.0, "Problemas digestivos", "https://georgiainjurylawyer.com/wp-content/uploads/2022/11/pitbull.jpg", 901234569L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Bella", "Poodle", 5, 11.0, "Cálculos renales", "https://www.lavanguardia.com/files/og_thumbnail/files/fp/uploads/2023/08/11/64d616bc0ed58.r_d.3943-2629-1521.jpeg", 102345680L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Riley", "Great Dane", 6, 60.0, "Problemas articulares", "https://www.ngenespanol.com/wp-content/uploads/2022/08/estudio-ayuda-a-conocer-origen-de-los-perros-1280x720.jpg", 234567893L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Zoe", "Cavalier King Charles Spaniel", 4, 15.0, "Problemas cardíacos", "https://emprendedores.es/wp-content/uploads/iStock-172866178-e1633008973869-1024x575.jpg", 345678904L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Chloe", "Boston Terrier", 3, 9.0, "Problemas dentales", "https://www.ngenespanol.com/wp-content/uploads/2022/08/estudio-ayuda-a-conocer-origen-de-los-perros-1280x720.jpg", 456789015L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Mia", "Siberian Husky", 5, 28.0, "Problemas respiratorios", "https://s3.abcstatics.com/media/familia/2022/04/06/perrook-k0o--1248x698@abc.jpg", 567890126L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Rocky", "Beagle", 4, 16.0, "Enfermedad gastrointestinal", "https://dogtime.com/wp-content/uploads/sites/12/2024/01/GettyImages-590608307.jpg?resize=1200,630", 678901237L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Riley", "Shih Tzu", 6, 9.0, "Cálculos urinarios", "https://s3.abcstatics.com/media/familia/2022/04/06/perrook-k0o--1248x698@abc.jpg", 789012348L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Oscar", "Boxer", 3, 27.0, "", "https://georgiainjurylawyer.com/wp-content/uploads/2022/11/pitbull.jpg", 890123459L, "Inactiva"));
        mascotaRepository.save(new Mascota("Luna", "Pomeranian", 4, 5.5, "", "https://s3.abcstatics.com/media/familia/2022/04/06/perrook-k0o--1248x698@abc.jpg", 901234570L, "Inactiva"));
        mascotaRepository.save(new Mascota("Sophie", "Pekingese", 5, 9.0, "", "https://www.ngenespanol.com/wp-content/uploads/2022/08/estudio-ayuda-a-conocer-origen-de-los-perros-1280x720.jpg", 102345681L, "Inactiva"));
        mascotaRepository.save(new Mascota("Jack", "Labrador", 6, 34.0, "", "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", 234567894L, "Inactiva"));
        mascotaRepository.save(new Mascota("Daisy", "Cocker Spaniel", 3, 15.0, "Problemas de piel", "https://georgiainjurylawyer.com/wp-content/uploads/2022/11/pitbull.jpg", 345678905L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Chloe", "Maltese", 4, 4.0, "Problemas dentales", "https://images.squarespace-cdn.com/content/v1/625ee79ee923a609e4bf10fa/62b6dd01-3c5a-4243-ad24-26fa8d7fbbae/maltese-sitting-on-sofa.png", 456789016L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Mia", "Dachshund", 5, 10.0, "Cálculos renales", "https://dogtime.com/wp-content/uploads/sites/12/2024/01/GettyImages-590608307.jpg?resize=1200,630", 567890127L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Riley", "Yorkshire", 3, 6.0, "Enfermedad renal", "https://www.ngenespanol.com/wp-content/uploads/2022/08/estudio-ayuda-a-conocer-origen-de-los-perros-1280x720.jpg", 678901238L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Oscar", "French Bulldog", 5, 12.0, "Problemas respiratorios", "https://dogtime.com/wp-content/uploads/sites/12/2024/01/GettyImages-590608307.jpg?resize=1200,630", 789012349L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Sophie", "Shih Tzu", 4, 7.0, "Problemas digestivos", "https://dogtime.com/wp-content/uploads/sites/12/2011/01/GettyImages-178920540-e1689348859523.jpg?w=1024", 890123460L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Luna", "Whippet", 6, 15.0, "Cálculos urinarios", "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", 901234571L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Rocky", "Havanese", 3, 8.0, "", "https://s3.abcstatics.com/media/familia/2022/04/06/perrook-k0o--1248x698@abc.jpg", 102345682L, "Inactiva"));
        mascotaRepository.save(new Mascota("Chloe", "Pekingese", 4, 9.0, "Alergias", "https://dogtime.com/wp-content/uploads/sites/12/2024/01/GettyImages-590608307.jpg?resize=1200,630", 234567895L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Riley", "Boston Terrier", 5, 11.0, "Problemas respiratorios", "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/08134610/Boston-Terrier-head-portrait-outdoors1.jpg", 345678906L, "En tratamiento"));
        mascotaRepository.save(new Mascota("Mia", "Shiba Inu", 3, 8.0, "", "https://www.ngenespanol.com/wp-content/uploads/2022/08/estudio-ayuda-a-conocer-origen-de-los-perros-1280x720.jpg", 456789017L, "Inactiva"));
        mascotaRepository.save(new Mascota("Jack", "Collie", 6, 25.0, "", "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal.jpg", 567890128L, "Inactiva"));



        List<Cliente> asociar = clienteRepository.findAll();
        List<Mascota> mascotasAsociar = mascotaRepository.findAll();

        for (int j = 0; j < mascotasAsociar.size(); j++) {
            for (int i = 0; i < asociar.size(); i++) {
                if (mascotasAsociar.get(j).getCedulaDuenho().equals(asociar.get(i).getCedula())) {
                    mascotasAsociar.get(j).setCliente(asociar.get(i));
                    mascotaRepository.save(mascotasAsociar.get(j));
                }
            }
        }


        /* 
            mascotaRepository.save(new Mascota("Firulais", "Siberiano", 4, 30, "Cáncer", "https://static.vecteezy.com/system/resources/thumbnails/008/951/892/small_2x/cute-puppy-pomeranian-mixed-breed-pekingese-dog-run-on-the-grass-with-happiness-photo.jpg", "123456789"));
            mascotaRepository.save(new Mascota("Rex", "Labrador", 3, 35, "Parvovirus", "https://cdn.pixabay.com/photo/2023/08/18/15/02/dog-8198719_640.jpg", "0"));
        */

        /*
        List<Cliente> asociar = clienteRepository.findAll();
        for (Cliente cliente : asociar) {
            
        }
        int cont = 0;
        int clienteIndex = 0;
        List<Cliente> clientes = clienteRepository.findAll(); // Asumiendo que tienes una forma de obtener todos los clientes

        
for (Mascota m : mascotaRepository.findAll()) {
    if (cont >= 100) {
        break;
    }

    // Asocia la mascota con el cliente actual
    m.setCliente(clientes.get(clienteIndex));

    // Guarda la mascota en el repositorio
    mascotaRepository.save(m);

    cont++;
    
    // Actualiza el índice del cliente
    clienteIndex++;
    
    // Reinicia el índice si es necesario
    if (clienteIndex >= clientes.size()) {
        clienteIndex = 0;
    }
    
    if (cont >= 100) {
        break;
    }
}

 
 */
    }
    
}