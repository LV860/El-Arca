package com.example.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class LandingPageController {
    @GetMapping("landingPage")
    public String landingPage (){
        return "/landingPage";
    }

    @GetMapping("loginCliente")
    public String loginCliente (){
        return "/loginCliente";
    }
    @GetMapping("loginVeterinario")
    public String loginVeterinario (){
        return "/loginVeterinario";
    }

    @GetMapping("aboutUsPage")
    public String aboutUsPage (){
        return "/aboutUsPage";
    }

    @GetMapping("contactPage")
    public String contactPage (){
        return "/contactPage";
    }
    @GetMapping("locationPage")
    public String locationPage (){
        return "/locationPage";
    }
}
