package main.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Data
@Entity
@IdClass(IngredientPropertyId.class)
@EqualsAndHashCode(exclude = {"ingredient", "property"})
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class IngredientProperty {
    @Id @ManyToOne Ingredient ingredient;

    @Id @ManyToOne Property property;

    private boolean isActive;

    public IngredientProperty(Ingredient ingredient, Property property, Boolean isActive){
        setIngredient(ingredient);
        setProperty(property);
        this.isActive = isActive;
    }

    public void setIngredient(Ingredient ingredient){
        this.ingredient = ingredient;
        ingredient.getIngredientProperties().add(this);
    }

    public void setProperty(Property property){
        this.property = property;
        property.getIngredientProperties().add(this);
    }
}
