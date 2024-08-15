package com.example.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class ContactPageController {

    //localhost:8080/home/contactPage
    @GetMapping("contactPage")
    public String landingPage (){
        return "html/contactPage";
    }
}
