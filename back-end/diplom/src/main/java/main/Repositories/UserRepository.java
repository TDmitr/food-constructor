package main.Repositories;

import main.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by igor on 3/2/18.
 */
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Long> {
}
