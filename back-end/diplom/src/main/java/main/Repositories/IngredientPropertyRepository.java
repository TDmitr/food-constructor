package main.Repositories;


import main.Entities.IngredientProperty;
import main.Entities.IngredientPropertyId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientPropertyRepository extends JpaRepository<IngredientProperty, IngredientPropertyId> {
}
