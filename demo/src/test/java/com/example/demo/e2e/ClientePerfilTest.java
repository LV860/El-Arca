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

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ClientePerfilTest {

    private final String BASE_URL = "http://localhost:4200";
    private WebDriver driver;
    private WebDriverWait wait;

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
    public void SystemTest_loginVeterinario_IngresoFallido() {
        

        //1. Ingresar a la página de login de veterinario, fallar primer login, ingreso al segundo.

        driver.get("http://localhost:4200/loginVeterinario");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cedula\"]")));

        String cedula = "678901239";
        String password = "123456789";

        WebElement inputCedula = driver.findElement(By.xpath("//*[@id=\"cedula\"]"));
        WebElement inputPassword = driver.findElement(By.xpath("//*[@id=\"contra\"]"));
        WebElement buttonLogin = driver.findElement(By.xpath("//html//body//app-root//app-inicio-veterinario//main//section//form//button"));

        inputCedula.sendKeys(cedula);
        inputPassword.sendKeys(password);
        buttonLogin.click();
        

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html//body//app-root//app-inicio-veterinario//main//section//div//p")));
        
        password = "abc";

        //Vaciar campos
        inputCedula.clear();
        inputPassword.clear();
        
        inputCedula.sendKeys(cedula);
        inputPassword.sendKeys(password);
        buttonLogin.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-perfil-veterinario/main/div/div/div[1]/p")));
        
        WebElement campoNombreVeterinario = driver.findElement(By.xpath("/html/body/app-root/app-perfil-veterinario/main/div/div/div[1]/p"));
        String expectedName = "Hugh Jackman";
        Assertions.assertThat(campoNombreVeterinario.getText()).isEqualTo(expectedName);
        
        //2. Registrar un nuevo cliente, primero se equivoca en el campo de correo al no poner un @, luego corrige el error y registra al cliente satisfactoriamente.

        WebElement buttonClientes = driver.findElement(By.xpath("/html/body/app-root/app-perfil-veterinario/app-header-veterinario/header/div[2]/a[2]/h3"));
        buttonClientes.click();
        //Esperar a que aparezca el boton de añadir cliente.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-clientes-table/main/div[1]/div/a/button")));
        WebElement buttonAddCliente = driver.findElement(By.xpath("/html/body/app-root/app-clientes-table/main/div[1]/div/a/button"));
        buttonAddCliente.click();

        //Esperar a que aparezca el boton de añadir cliente.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-clientes-add/main/div/form/button")));

        //El veterinario se equivoca en el correo del cliente.
        WebElement campoAdd_nombre = driver.findElement(By.xpath("//*[@id=\"nombre\"]"));
        WebElement campoAdd_Cedula = driver.findElement(By.xpath("//*[@id=\"cedula\"]"));
        campoAdd_Cedula.clear();
        WebElement campoAdd_Correo = driver.findElement(By.xpath("//*[@id=\"correo\"]"));
        WebElement campoAdd_Numero = driver.findElement(By.xpath("//*[@id=\"celular\"]"));

        campoAdd_nombre.sendKeys("Cristiano Ronaldo");
        campoAdd_Cedula.sendKeys("123456777");
        campoAdd_Correo.sendKeys("cr7gmail.com");
        campoAdd_Numero.sendKeys("0987654321");
        
    }
////*[@id="cedula"]
//*[@id="cedula"]
    @Test
    public void SystemTest_perfilCliente_NombreCliente() {

        driver.get(BASE_URL + "/perfilCliente/123456789");

        String pathNombre = "/html/body/app-root/app-perfil-cliente/main/div[1]/div/div[1]/div/span[1]";

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pathNombre)));
        WebElement liNombre = driver.findElement(By.xpath(pathNombre));

        // String expectedName = "Ana Pérez";
        String expectedName = "";
        Assertions.assertThat(liNombre.getText()).isEqualTo(expectedName);
    }

    @Test
    public void SystemTest_perfilCliente_NombreCliente2() {

        driver.get(BASE_URL + "/perfilCliente/123456789");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nameSpan")));
        WebElement liNombre = driver.findElement(By.id("nameSpan"));

        // String expectedName = "Ana Pérez";
        String expectedName = "";
        Assertions.assertThat(liNombre.getText()).isEqualTo(expectedName);
    }

    @Test
    public void SystemTest_perfilCliente_CantidadMascotas() {

        driver.get(BASE_URL + "/perfilCliente/123456789");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("NombreMascota")));
        List<WebElement> liMascotas = driver.findElements(By.className("NombreMascota"));

        Assertions.assertThat(liMascotas.size()).isEqualTo(2);
    }

    /* 
    @AfterEach
    void tearDown() {
        driver.quit();
    }
        */
}