package main.Controllers;

import main.Entities.*;
import main.Repositories.DishRepository;
import main.Repositories.DishTypeRepository;
import main.Repositories.IngredientRepository;
import main.Repositories.IngredientTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/constructor")
public class ConstructorController {

    @Autowired
    DishTypeRepository dishTypeRepository;
    @Autowired
    IngredientTypeRepository ingredientTypeRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    DishRepository dishRepository;

    @GetMapping("/dish")
    public ResponseEntity<?> getDishType(){
        //create dish type: Dishes auto, ingredientTypes manual, necessaryIngredients manual
        DishType dishType = new DishType("Salat", 10, 0, new HashSet<>(), new HashSet<>(), new ArrayList<>());
        //create ingredient type: ingredients auto, dish types manual, property types manual;
        IngredientType ingredientType = new IngredientType("Vegetables", new byte[]{}, new HashSet<>(), new HashSet<>(), new HashSet<>());
        //create ingredient: dishes manual+, dish types manual+, ingredient properties auto
        Ingredient ingredient1 = new Ingredient("tomato", "100", 20, ingredientType, new byte[]{}, new HashSet<>(), new HashSet<>(), new HashSet<>());
        Ingredient ingredient2 = new Ingredient("cucumber", "50", 10, ingredientType, new byte[]{}, new HashSet<>(), new HashSet<>(), new HashSet<>());
        //create dish: ingredients manual+, orderDishes auto
        Dish dish = new Dish("salat1", dishType, new ArrayList<>(), new HashSet<>());

        dish.getIngredients().add(ingredient1);
        dish.getIngredients().add(ingredient2);
        ingredient1.getDishes().add(dish);
        ingredient2.getDishes().add(dish);

        ingredient1.getDishTypes().add(dishType);
        dishType.getNecessaryIngredients().add(ingredient1);

        dishType.getIngredientTypes().add(ingredientType);
        ingredientType.getDishTypes().add(dishType);

        //create order: dishes auto
        Order order = new Order(null, "address", new HashSet<>());
        // create order dish connection
        OrderDish orderDish = new OrderDish(order, dish, 1);

        PropertyType propertyType = new PropertyType("condition", new HashSet<>(), new HashSet<>());
        propertyType.getIngredientTypes().add(ingredientType);
        ingredientType.getPropertyTypes().add(propertyType);

        Property property1 = new Property("fresh", propertyType, new HashSet<>());
        Property property2 = new Property("canned", propertyType, new HashSet<>());

        IngredientProperty ingredientProperty1 = new IngredientProperty(ingredient1, property1, true);
        IngredientProperty ingredientProperty2 = new IngredientProperty(ingredient1, property2, false);

        return ResponseEntity.ok(dishType);
    }
}
