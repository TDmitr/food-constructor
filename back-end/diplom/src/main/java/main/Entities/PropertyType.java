package main.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "property_type")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
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

    @OneToMany(mappedBy = "propertyType")
    private Set<Property> properties;

    public PropertyType(String name, Set<IngredientType> ingredientTypes, Set<Property> properties) {
        this.name = name;
        this.ingredientTypes = ingredientTypes;
        this.properties = properties;
    }

    public PropertyType(String name) {
        this(name,new HashSet<>(),new HashSet<>());
    }

    public PropertyType() {
    }
}
