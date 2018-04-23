package main.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "property")
@EqualsAndHashCode(exclude = "propertyType")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
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
        setPropertyType(propertyType);
        this.ingredientProperties = ingredientProperties;
    }

    public Property(String name, PropertyType propertyType) {
        this(name,propertyType, new HashSet<>());
    }

    public Property() {
    }

    public void setPropertyType(PropertyType propertyType){
        this.propertyType = propertyType;
        propertyType.getProperties().add(this);
    }
}
