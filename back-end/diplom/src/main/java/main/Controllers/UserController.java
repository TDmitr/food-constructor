package main.Controllers;

import main.Entities.User;
import main.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by igor on 3/2/18.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<User> allUsers(){
        return userRepository.findAll();
    }
}
