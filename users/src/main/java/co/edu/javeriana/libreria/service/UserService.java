package co.edu.javeriana.libreria.service;

import co.edu.javeriana.libreria.entity.User;
import co.edu.javeriana.libreria.repository.UserRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // POST
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // GET all
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // PUT
    public User updateAllUser(User user, String username) {

        if(!username.equals(user.getUsername()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username from path variable does not match object username");

        if(userRepository.findById(username).isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username does not exist");

        return userRepository.save(user);
    }


    // DELETE
    public String deleteUser(String username) {

        if(userRepository.findById(username).isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username does not exist");


        User user = userRepository.findUserByUsername(username);
        if(user.getActivated().equals("FALSE"))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already deactivated");

        user.setActivated("FALSE");
        userRepository.save(user);
        return "deactivated user " + username;
    }

    // PUT ACTIVATE
    public String activateUser(String username) {

        if(userRepository.findById(username).isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username does not exist");

        User user = userRepository.findUserByUsername(username);
        if(user.getActivated().equals("TRUE"))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already activated");

        user.setActivated("TRUE");
        userRepository.save(user);
        return "activated user " + username;
    }
}
