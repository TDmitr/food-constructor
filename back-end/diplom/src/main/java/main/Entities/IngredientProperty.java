package main.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Data
@Entity
@IdClass(IngredientPropertyId.class)
public class IngredientProperty {
    @Id @ManyToOne Ingredient ingredient;

    @Id @ManyToOne Property property;

    private boolean isActive;
}
