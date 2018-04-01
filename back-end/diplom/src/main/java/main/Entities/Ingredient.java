package main.Entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private double weight;

    private BigDecimal price;

    @ManyToOne
    private Type type;

    @ManyToMany
    private List<Property> addedProperties;

    public Ingredient(String name, double weight, BigDecimal price, Type type, List<Property> addedProperties) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.type = type;
        this.addedProperties = addedProperties;
    }

    public Ingredient() {
    }
}
