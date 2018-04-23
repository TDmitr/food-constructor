package main.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Data
@Entity
@Table(name = "dish")
@EqualsAndHashCode(exclude = {"dishType","ingredients"})
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="dish_type_id", nullable=false)
    private DishType dishType;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "dish_ingredient",
            joinColumns = { @JoinColumn(name = "dish_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_id") }
    )
    private List<Ingredient> ingredients;

    @OneToMany(mappedBy = "dish")
    private Set<OrderDish> orderDishes;

    public Dish(String name, DishType dishType, List<Ingredient> ingredients,Set<OrderDish> orderDishes) {
        this.name = name;
//        this.dishType = dishType;
        setDishType(dishType);
        this.ingredients = ingredients;
        ingredients.addAll(dishType.getNecessaryIngredients());
        this.orderDishes = orderDishes;
    }

    public Dish(String name, DishType dishType){
        this(name,dishType, new ArrayList<>(), new HashSet<>());
    }

    public Dish(){}

    protected double getPrice()
    {
        double result = 0;
        List<Ingredient> priceIngredients = new ArrayList<>(ingredients);
        priceIngredients.removeAll(dishType.getNecessaryIngredients());
        for (Ingredient ingredient: priceIngredients) {
            result += ingredient.getPrice();
        }
        return result + dishType.getBasePrice();
    }

    public void setDishType(DishType dishType){
        this.dishType = dishType;
        dishType.getDishes().add(this);
    }


}
