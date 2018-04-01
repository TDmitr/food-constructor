package main.Entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany
    private List<Ingredient> ingredients;

    @ManyToOne
    private DishType dishType;

    public Dish(String name, List<Ingredient> ingredients, DishType dishType) {
        this.name = name;
        this.ingredients = ingredients;
        this.dishType = dishType;
        ingredients.addAll(dishType.getNecessaryIngredients());
    }

    public Dish(){}

    protected BigDecimal getPrice()
    {
        BigDecimal result = BigDecimal.valueOf(0);
        List<Ingredient> priceIngredients = new ArrayList<>(ingredients);
        priceIngredients.removeAll(dishType.getNecessaryIngredients());
        for (Ingredient ingredient: priceIngredients) {
            result = result.add(ingredient.getPrice());
        }
        return result.add(dishType.getBasePrice());
    }

    protected double getWeight()
    {
        List<Ingredient> weightIngredients = new ArrayList<Ingredient>(ingredients);
        weightIngredients.removeAll(dishType.getNecessaryIngredients());
        return weightIngredients.stream().mapToDouble(Ingredient::getWeight).sum() + dishType.getBaseWeight();
    }


}
