package main.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="property_type_id", nullable=false)
    private PropertyType propertyType;

    @OneToMany(mappedBy = "property")
    private Set<IngredientProperty> ingredientProperties;

    public Property(String name, PropertyType propertyType, Set<IngredientProperty> ingredientProperties) {
        this.name = name;
        this.propertyType = propertyType;
        this.ingredientProperties = ingredientProperties;
    }

    public Property(String name, PropertyType propertyType) {
        this(name,propertyType, new HashSet<>());
    }

    public Property() {
    }
}
