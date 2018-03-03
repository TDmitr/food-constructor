package main.Controllers;

import main.CustomErrorType;
import main.Entities.User;
import main.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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

    // -------------------Retrieve All Users---------------------------------------------

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // -------------------Create a User-------------------------------------------

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder){
        if(userRepository.findByEmail(user.getEmail()) != null){
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A User with name " +
                    user.getName() + " already exist."), HttpStatus.CONFLICT);
        }
        userRepository.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a User ------------------------------------------------

//    @RequestMapping(value = "/user/{email}", method = RequestMethod.PUT)
//    public ResponseEntity<?> updateUser(@PathVariable("email") String email, @RequestBody User user) {
//        User currentUser = userRepository.findByEmail(email);
//
//        if (currentUser == null) {
//            return new ResponseEntity<>(new CustomErrorType("Unable to upate. User with email " + email + " not found."),
//                    HttpStatus.NOT_FOUND);
//        }
//
//        currentUser.setName(user.getName());
//
//        userRepository.(currentUser);
//        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
//    }

    // ------------------- Delete a User-----------------------------------------

    @DeleteMapping("/user/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable("email") String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. User with email " + email + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        userRepository.deleteByEmail(email);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
