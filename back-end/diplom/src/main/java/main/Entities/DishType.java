package main.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "dish_type")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class DishType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private double basePrice;

    private double baseWeight;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "dishType")
    private Set<Dish> dishes;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "dish_type_ingredient",
            joinColumns = { @JoinColumn(name = "dish_type_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_id") }
    )
    private List<Ingredient> necessaryIngredients;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "dish_type_ingredient_type",
            joinColumns = { @JoinColumn(name = "dish_type_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_type_id") }
    )
    private Set<IngredientType> ingredientTypes;

    public DishType(String name, double basePrice, double baseWeight, Set<Dish> dishes, Set<IngredientType> ingredientTypes, List<Ingredient> necessaryIngredients) {
        this.name = name;
        this.basePrice = basePrice;
        this.baseWeight = baseWeight;
        this.dishes = dishes;
        this.ingredientTypes = ingredientTypes;
        this.necessaryIngredients = necessaryIngredients;
    }

    public DishType(String name, double basePrice, double baseWeight) {
        this(name,basePrice,baseWeight,new HashSet<>(),new HashSet<>(),new ArrayList<>());
    }

    public DishType() {
    }


    public void addDish(Dish dish){
        this.dishes.add(dish);

    }
}
