package main.Repositories;

import main.Entities.Authority;
import main.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 3/2/18.
 */
@RepositoryRestResource
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
    void deleteByUsername(String email);
    List<User> findUsersByAuthority(Authority auth);
}
