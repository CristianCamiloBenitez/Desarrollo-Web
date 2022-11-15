package co.edu.javeriana.libreria.controller;

import co.edu.javeriana.libreria.entity.User;
import co.edu.javeriana.libreria.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User addNewUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @PutMapping("/updateAll/{username}")
    public User updateUser(@RequestBody @Validated User user, @PathVariable("username") final String username) {
        return userService.updateAllUser(user, username);
    }

    @DeleteMapping(path = "/delete/{username}")
    public @ResponseBody String deleteUser(@PathVariable("username") final String username) {
        return userService.deleteUser(username);
    }

    @PutMapping("/activate/{username}")
    public String updateUser(@PathVariable("username") final String username) {
        return userService.activateUser(username);
    }
}
