package com.example.demo.e2e;

import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CasoUso2 {

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
        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void SystemTest_Caso_de_uso_2() {

        // 1. Iniciar sesión como veterinario
        driver.get(BASE_URL + "/loginVeterinario");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cedula")));
        WebElement inputCedula = driver.findElement(By.id("cedula"));
        WebElement inputPassword = driver.findElement(By.id("contra"));
        WebElement buttonLogin = driver.findElement(By.id("btnInicioVet"));

        inputCedula.sendKeys("678901239");
        inputPassword.sendKeys("abc");
        buttonLogin.click();

        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(InicioPath + "app-perfil-veterinario//main//div//div//div[1]//p")));

        WebElement campoNombreVeterinario = driver
                .findElement(By.xpath(InicioPath + "app-perfil-veterinario//main//div//div//div[1]//p"));
        String expectedName = "Hugh Jackman";
        Assertions.assertThat(campoNombreVeterinario.getText()).isEqualTo(expectedName);

        // 2. Buscar la mascota en la sección de búsqueda

        // 2.1 Acceder a la pestaña de mascotas
        WebElement botonMascotas = driver.findElement(
                By.xpath(InicioPath + "app-perfil-veterinario//app-header-veterinario//header//div[2]//a[3]//h3"));
        botonMascotas.click();

        // 2.2 Encontrar el input para buscar una mascota
        WebElement searchInput = driver
                .findElement(By.xpath("//*[@id=\"formularioFiltro\"]/form/input"));
        searchInput.sendKeys("Max");
        searchInput.submit();

        // 3. Seleccionar la mascota y añadir un tratamiento
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/app-root/app-mascotas-table/main/section[3]/table/tbody/tr")));
        WebElement mascota = driver.findElement(
                By.xpath("/html/body/app-root/app-mascotas-table/main/section[3]/table/tbody/tr/td[8]/button[3]"));
        mascota.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/app-root/app-mascotas-tratamiento/main/div/form/button[1]")));

        WebElement precioTratamiento = driver.findElement(By.id("precio"));
        WebElement idDroga = driver.findElement(By.id("drogaIdLong"));
        WebElement fechaTratamiento = driver.findElement(By.id("fecha"));
        WebElement saveTreatmentButton = driver
                .findElement(By.xpath("/html/body/app-root/app-mascotas-tratamiento/main/div/form/button[1]"));

        precioTratamiento.sendKeys("500");
        idDroga.sendKeys("1");
        fechaTratamiento.sendKeys("30/10/2024");
        saveTreatmentButton.click();

        // 4. Verificar que el tratamiento se haya registrado correctamente
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(InicioPath + "app-mascotas-table//main//section[1]//div//a//button")));
        WebElement Max = driver
                .findElement(By.xpath("//*[@id=\"formularioFiltro\"]/form/input"));
        Max.sendKeys("Max");
        Max.submit();
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/app-root/app-mascotas-table/main/section[3]/table/tbody/tr")));
        WebElement mascotaMax = driver.findElement(
                By.xpath("/html/body/app-root/app-mascotas-table/main/section[3]/table/tbody/tr/td[8]/button[3]"));
        mascotaMax.click();
        WebElement historialMascota = driver
                .findElement(By.xpath("/html/body/app-root/app-mascotas-tratamiento/main/div/form/button[2]"));
        historialMascota.click();

        /*
         * // 5. Iniciar sesión como administrador para verificar ganancias y cantidad
         * de
         * // tratamientos
         * WebElement buttonCerrarSesion =
         * driver.findElement(By.xpath("//button[@id='btnLogout']"));
         * buttonCerrarSesion.click();
         * 
         * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
         * "//button[@id='btnLoginAdmin']")));
         * WebElement adminLoginButton =
         * driver.findElement(By.xpath("//button[@id='btnLoginAdmin']"));
         * adminLoginButton.click();
         * 
         * wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cedula")));
         * WebElement adminCedula = driver.findElement(By.id("cedula"));
         * WebElement adminPassword = driver.findElement(By.id("contra"));
         * WebElement buttonLoginAdmin = driver.findElement(By.id("btnInicioAdmin"));
         * 
         * adminCedula.sendKeys("admin");
         * adminPassword.sendKeys("adminpass");
         * buttonLoginAdmin.click();
         * 
         * // 6. Verificar las ganancias y la cantidad de medicamentos suministrados
         * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
         * "//main//div[@id='dashboard']")));
         * 
         * WebElement totalMedicamentos =
         * driver.findElement(By.id("totalMedicamentos"));
         * WebElement totalGanancias = driver.findElement(By.id("totalGanancias"));
         * 
         * // Verificar valores esperados (reemplaza con los valores correctos en base a
         * // los datos)
         * Assertions.assertThat(totalMedicamentos.getText()).isEqualTo("1"); // Cambia
         * según el conteo esperado
         * Assertions.assertThat(totalGanancias.getText()).isEqualTo("5000"); // Cambia
         * según la ganancia esperada
         */
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
