package main.Entities;

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
public class DishType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private BigDecimal basePrice;

    private double baseWeight;

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

    public DishType(String name, BigDecimal basePrice, double baseWeight, Set<Dish> dishes, Set<IngredientType> ingredientTypes, List<Ingredient> necessaryIngredients) {
        this.name = name;
        this.basePrice = basePrice;
        this.baseWeight = baseWeight;
        this.dishes = dishes;
        this.ingredientTypes = ingredientTypes;
        this.necessaryIngredients = necessaryIngredients;
    }

    public DishType(String name, BigDecimal basePrice, double baseWeight) {
        this(name,basePrice,baseWeight,new HashSet<>(),new HashSet<>(),new ArrayList<>());
    }

    public DishType() {
    }
}
