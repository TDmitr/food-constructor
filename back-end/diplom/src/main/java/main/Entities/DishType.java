package main.Entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class DishType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany
    private List<Ingredient> necessaryIngredients;

    @ManyToMany
    private List<Type> types;

    private BigDecimal basePrice;

    private double baseWeight;

    public DishType(String name, List<Ingredient> necessaryIngredients, List<Type> types, BigDecimal basePrice, double baseWeight) {
        this.name = name;
        this.necessaryIngredients = necessaryIngredients;
        this.types = types;
        this.basePrice = basePrice;
        this.baseWeight = baseWeight;
    }

    public DishType() {
    }
}
