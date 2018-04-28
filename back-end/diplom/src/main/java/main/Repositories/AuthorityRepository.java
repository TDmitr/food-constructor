package main.Repositories;

import main.Entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;

/**
 * Created by igor on 3/20/18.
 */
@RepositoryRestResource
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
