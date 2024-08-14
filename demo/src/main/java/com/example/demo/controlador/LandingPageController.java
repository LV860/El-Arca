package com.example.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class LandingPageController {
    @GetMapping("landingPage")
    public String landingPage (){
        return "html/landingPage";
    }
}
