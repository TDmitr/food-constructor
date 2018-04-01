package main.Controllers;

import com.google.common.hash.Hashing;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.CustomErrorType;
import main.Entities.Authority;
import main.Entities.User;
import main.Repositories.AuthorityRepository;
import main.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by igor on 3/2/18.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityRepository authorityRepository;

    @GetMapping("/users")
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

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody TempUser tempUser, UriComponentsBuilder uriComponentsBuilder){
        if(userRepository.findUserByUsername(tempUser.getUsername()) != null){
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A User with name " +
                    tempUser.getUsername() + " already exist."), HttpStatus.CONFLICT);
        }

        Authority tempAuth = authorityRepository.findAuthorityByAuthority("ROLE_" + tempUser.getAuthority().toUpperCase());
        if(tempAuth == null) {
            return new ResponseEntity<>(new CustomErrorType("Unable to create. No such authority " +
                    tempUser.getAuthority()), HttpStatus.CONFLICT);
        }
        String passHex = Hashing.sha256()
                .hashString(tempUser.password, StandardCharsets.UTF_8)
                .toString();
        User newUser = User.builder()
                .authority(tempAuth)
                .username(tempUser.username)
                .password(passHex)
                .enabled(true)
                .build();
        userRepository.save(newUser);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/user/{id}").buildAndExpand(newUser.getId()).toUri());
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

    @DeleteMapping("/users/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable("email") String email) {
        User user = userRepository.findUserByUsername(email);
        if (user == null) {
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. User with email " + email + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        userRepository.deleteByUsername(email);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity findUserById(@PathVariable("id") Integer id){
        User user = userRepository.findOne(id);
        if (user == null) {
            return new ResponseEntity<>(new CustomErrorType("Unable to find. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Data
    private static final class TempUser{
        private String username;
        private String password;
        private String authority;
    }
}
