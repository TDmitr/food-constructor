package main.Repositories;


import main.Entities.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long> {
}
