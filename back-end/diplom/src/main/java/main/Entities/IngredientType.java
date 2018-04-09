package main.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "ingredient_type")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class IngredientType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Lob
    @Column(name="image", columnDefinition="mediumblob")
    private byte[] image;

    @OneToMany(mappedBy = "ingredientType")
    @JsonBackReference
    private Set<Ingredient> ingredients;

    @ManyToMany(mappedBy = "ingredientTypes")
    private Set<DishType> dishTypes;

    @ManyToMany(mappedBy = "ingredientTypes")
    private Set<PropertyType> propertyTypes;

    public IngredientType(String name, byte[] image, Set<Ingredient> ingredients, Set<DishType> dishTypes,
                          Set<PropertyType> propertyTypes) {
        this.name = name;
        this.image = image;
        this.ingredients = ingredients;
        this.dishTypes = dishTypes;
        this.propertyTypes = propertyTypes;
    }

    public IngredientType(String name) {
        this(name, new byte[]{},new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    public IngredientType(String name, byte[] image) {
        this(name, image,new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    public IngredientType() {
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        ingredient.setIngredientType(this);
    }

    public void addDishType(DishType dishType) {
        dishTypes.add(dishType);
        dishType.getIngredientTypes().add(this);
    }

    public void addPropertyType(PropertyType propertyType) {
        propertyTypes.add(propertyType);
        propertyType.getIngredientTypes().add(this);
    }


}
