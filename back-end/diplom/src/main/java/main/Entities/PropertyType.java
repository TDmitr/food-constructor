package main.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "property_type")
public class PropertyType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "property_type_ingredient_type",
            joinColumns = { @JoinColumn(name = "property_type_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_type_id") }
    )
    private Set<IngredientType> ingredientTypes;

    public PropertyType(String name, Set<IngredientType> ingredientTypes) {
        this.name = name;
        this.ingredientTypes = ingredientTypes;
    }

    public PropertyType(String name) {
        this(name,new HashSet<>());
    }

    public PropertyType() {
    }
}
