package main.Repositories;


import main.Entities.PropertyName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyNameRepository extends JpaRepository<PropertyName, Long> {
}
