package main.Repositories;


import main.Entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByIngredientTypeId(Long Id);
    Ingredient findById(Long Id);
    Ingredient findByName(String name);
}
