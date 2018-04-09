package main.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

//@Data
@Getter
@Setter
@Entity
@Table(name = "ingredient")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Ingredient {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String weight;

    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ingredient_type_id")
    @JsonIgnoreProperties("ingredients")
    private IngredientType ingredientType;

    @Lob
    @Column(name="image", columnDefinition="mediumblob")
    private byte[] image;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Dish> dishes;

    @ManyToMany(mappedBy = "necessaryIngredients")
    private Set<DishType> dishTypes;

    @OneToMany(mappedBy = "ingredient")
    private Set<IngredientProperty> ingredientProperties;

    public Ingredient(String name, String weight, BigDecimal price, IngredientType ingredientType, byte[] image,
                      Set<Dish> dishes, Set<DishType> dishTypes, Set<IngredientProperty> ingredientProperties) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.ingredientType = ingredientType;
        this.image = image;
        this.dishes = dishes;
        this.dishTypes = dishTypes;
        this.ingredientProperties = ingredientProperties;
    }

    public Ingredient(String name, String weight, BigDecimal price, IngredientType ingredientType, byte[] image) {
        this(name,weight,price,ingredientType,image, new HashSet<>(), new HashSet<>(),new HashSet<>());
    }

    public Ingredient(String name, String weight, BigDecimal price, IngredientType ingredientType) {
        this(name,weight,price,ingredientType,new byte[]{}, new HashSet<>(), new HashSet<>(),new HashSet<>());
    }

    public Ingredient() {
    }
}
