package co.edu.javeriana.libreria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingPAgeController {
    @RequestMapping("/")
    public String landing() {
        return "library backend - Books microservice";
    }
}