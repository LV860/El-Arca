package com.example.demo.e2e;

import java.time.Duration;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.swagger.v3.oas.models.security.SecurityScheme.In;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CasoUso1 {

    private final String BASE_URL = "http://localhost:4200";
    private WebDriver driver;
    private WebDriverWait wait;
    private final String InicioPath = "//html//body//app-root//";

    @BeforeEach
    public void init() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        // chromeOptions.addArguments("--headless");

        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @Test
    public void SystemTest_Caso_de_uso_1() {
        

        //1. Ingresar a la página de login de veterinario, fallar primer login, ingreso al segundo.

        driver.get(BASE_URL + "/loginVeterinario");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cedula\"]")));

        String cedula = "678901239";
        String password = "123456789";

        WebElement inputCedula = driver.findElement(By.xpath("//*[@id=\"cedula\"]"));
        WebElement inputPassword = driver.findElement(By.xpath("//*[@id=\"contra\"]"));
        WebElement buttonLogin = driver.findElement(By.id("btnInicioVet"));

        inputCedula.sendKeys(cedula);
        inputPassword.sendKeys(password);
        buttonLogin.click();
        

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(InicioPath + "app-inicio-veterinario//main//section//div//p")));
        
        password = "abc";

        //Vaciar campos
        inputCedula.clear();
        inputPassword.clear();
        
        inputCedula.sendKeys(cedula);
        inputPassword.sendKeys(password);
        buttonLogin.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(InicioPath + "app-perfil-veterinario//main//div//div//div[1]//p")));
        
        WebElement campoNombreVeterinario = driver.findElement(By.xpath(InicioPath + "app-perfil-veterinario//main//div//div//div[1]//p"));
        String expectedName = "Hugh Jackman";
        Assertions.assertThat(campoNombreVeterinario.getText()).isEqualTo(expectedName);
        
        //2. Registrar un nuevo cliente, primero se equivoca en el campo de correo al no poner un @, luego corrige el error y registra al cliente satisfactoriamente.

        //2.1 Ingresar a la sección de clientes.
        WebElement buttonClientes = driver.findElement(By.xpath(InicioPath + "app-perfil-veterinario//app-header-veterinario//header//div[2]//a[2]//h3"));
        buttonClientes.click();
        //2.2 Esperar a que aparezca el boton de añadir cliente de la pagina con todos los clientes.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(InicioPath + "app-clientes-table//main//div[1]//div//a//button")));
        WebElement buttonAddCliente = driver.findElement(By.xpath(InicioPath + "app-clientes-table//main//div[1]//div//a//button"));
        buttonAddCliente.click();

        //2.3 Esperar a que aparezca el boton en el formulario de añadir cliente.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(InicioPath + "app-clientes-add//main//div//form//button")));

        //2.4 El veterinario se equivoca en el correo del cliente.
        WebElement campoAdd_nombre = driver.findElement(By.xpath("//*[@id=\"nombre\"]"));
        WebElement campoAdd_Cedula = driver.findElement(By.xpath("//*[@id=\"cedula\"]"));
        campoAdd_Cedula.clear();
        WebElement campoAdd_Correo = driver.findElement(By.xpath("//*[@id=\"correo\"]"));
        WebElement campoAdd_Numero = driver.findElement(By.xpath("//*[@id=\"celular\"]"));
        WebElement campoAdd_ButtonaddForm = driver.findElement(By.xpath(InicioPath + "app-clientes-add//main//div//form//button"));

        campoAdd_nombre.sendKeys("Cristiano Ronaldo");
        campoAdd_Cedula.sendKeys("123456777");
        campoAdd_Correo.sendKeys("cr7gmail.com");
        campoAdd_Numero.sendKeys("987654321");

        campoAdd_ButtonaddForm.click();

        //2.5 Esperar a que aparezca el mensaje de correo invalido.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(InicioPath + "app-clientes-add//main//div//form//div[2]//div[1]//div//div")));
        
        //2.6 Corregir el campo de correo colocando @ en el campo.
        campoAdd_Correo.clear();
        campoAdd_Correo.sendKeys("cr7@gmail.com");

        //2.7 Registrar al cliente.
        campoAdd_ButtonaddForm.click();

        //2.8 Esperar a que la pagina nos redirija a la pagina de clientes.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(InicioPath + "app-clientes-table//main//div[1]//h1")));


        //3. Registrar una nueva mascota y salir del portal del veterinario.

        //3.1 Ingresar a la sección de mascota. 
        WebElement buttonMascotas = driver.findElement(By.xpath(InicioPath + "app-clientes-table//app-header-veterinario//header//div[2]//a[3]"));
        buttonMascotas.click();
        //3.2 Esperar a que aparezca el boton de añadir mascota de la pagina con todos las mascotas.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(InicioPath + "app-mascotas-table//main//section[1]//div//a//button")));

        
        WebElement buttonAddMascota = driver.findElement(By.xpath(InicioPath + "app-mascotas-table//main//section[1]//div//a//button"));
        buttonAddMascota.click();
 
         //3.3 Esperar a que aparezca el boton en el formulario de añadir mascota. 
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(InicioPath + "app-mascotas-add//main//div//form//button")));


        //3.4 El veterinario añade una nueva mascota.
        WebElement mascota_nombre = driver.findElement(By.xpath("//*[@id=\"nombre\"]"));
        WebElement mascota_CedulaDuenho = driver.findElement(By.xpath("//*[@id=\"cedulaDuenho\"]"));
        mascota_CedulaDuenho.clear();
        WebElement mascota_raza = driver.findElement(By.xpath("//*[@id=\"raza\"]"));
        WebElement mascota_edad = driver.findElement(By.xpath("//*[@id=\"edad\"]"));
        mascota_edad.clear();
        WebElement mascota_peso = driver.findElement(By.xpath("//*[@id=\"peso\"]"));
        mascota_peso.clear();
        WebElement mascota_enfermedad = driver.findElement(By.xpath("//*[@id=\"enfermedad\"]"));
        WebElement mascota_urlImagen = driver.findElement(By.xpath("//*[@id=\"urlImagen\"]"));
        WebElement mascota_btnAddForm = driver.findElement(By.xpath(InicioPath + "app-mascotas-add//main//div//form//button"));

        mascota_nombre.sendKeys("Ramon");
        mascota_CedulaDuenho.sendKeys("123456777");
        mascota_raza.sendKeys("Beagle");
        mascota_edad.sendKeys("7");
        mascota_peso.sendKeys("12");
        mascota_enfermedad.sendKeys("Cancer");
        mascota_urlImagen.sendKeys("https://georgiainjurylawyer.com/wp-content/uploads/2022/11/pitbull.jpg");
        
        

        mascota_btnAddForm.click();

        //3.5 Esperar a que aparezca de nuevo la tabla de mascotas.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(InicioPath + "app-mascotas-table//main//section[1]//div//a//button")));

        //4. Cerrar el portal del veterinario e Iniciar sesion como dueño.

        //4.1 Cerrar sesion   
        WebElement buttonCerrarSesion = driver.findElement(By.xpath(InicioPath + "app-mascotas-table//app-header-veterinario//header//div[3]//button"));
        buttonCerrarSesion.click();
        //4.2 Esperar a que aparezca el home  
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(InicioPath + "app-home//app-header-page//header//div[1]//a//h1")));

        

        //4.3 Iniciar sesion   
        WebElement buttonIniciarSesion = driver.findElement(By.xpath(InicioPath + "app-home//app-header-page//header//div[3]//a//button"));
        buttonIniciarSesion.click();
        //4.4 Esperar a que aparezca el inicar sesion para el cliente  
       
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(InicioPath + "app-inicio-cliente//main//section//form//button")));


        //4.5 Iniciar sesion del dueño.
        String cedulaDuenho = "123456777";
        

        WebElement inputCedulaDuenho = driver.findElement(By.xpath("//*[@id=\"cedula\"]"));
       
        WebElement buttonLoginDuenho = driver.findElement(By.id("btnInicioCliente"));

        inputCedulaDuenho.sendKeys(cedulaDuenho);
      
        buttonLoginDuenho.click();
        

        //4.6 Esperar a que aparezca el perfil del dueño.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nameSpan\"]")));
        


        //4.7 Verificacion de datos correctos
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("card-nombre-estadoicon")));
        List<WebElement> liMascotas = driver.findElements(By.className("card-nombre-estadoicon"));

        Assertions.assertThat(liMascotas.size()).isEqualTo(1);


    }


    
    @AfterEach
    void tearDown() {
        driver.quit();
    }
        
}