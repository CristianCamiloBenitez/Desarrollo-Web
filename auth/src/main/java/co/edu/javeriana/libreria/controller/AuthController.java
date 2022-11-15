package co.edu.javeriana.libreria.controller;

import co.edu.javeriana.libreria.dto.User;
import co.edu.javeriana.libreria.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) throws Exception {
        return authService.login(username, pwd);
    }
}
