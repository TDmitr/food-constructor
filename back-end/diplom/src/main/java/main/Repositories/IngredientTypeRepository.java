package main.Repositories;


import main.Entities.IngredientType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientTypeRepository extends JpaRepository<IngredientType, Long> {
    IngredientType findByName(String name);

    IngredientType findById(Long Id);
}
