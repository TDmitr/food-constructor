package main;

import main.Entities.*;
import main.Repositories.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DBTest {
    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private DishTypeRepository dishTypeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private PropertyNameRepository propertyNameRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    private Type meat;

    private Type bread;

    private PropertyName roast;

    private Property wellDoneRoast;

    private Property mediumRoast;

    private ArrayList<Ingredient> necessaryIngs = new ArrayList<>();;

    private ArrayList<Type> validTypes = new ArrayList<>();;

    private DishType burger;

    private ArrayList<Ingredient> bigBurgerIngredients = new ArrayList<>();

    private ArrayList<Ingredient> smallBurgerIngredients = new ArrayList<>();

    private ArrayList<Dish> dishList = new ArrayList<>();

    private User user;

    /*
    @Test
    public void contextLoads() {
        Type meat = createType("Meat");
        Ingredient chickenMeat = createIngredient("Chicken meat", 0.3d,
                new BigDecimal(10), meat, new ArrayList<>());
        PropertyName roast = createPropertyName("Roast",meat);
        Property wellDoneRoast = createProperty("Well done roast",roast);
        chickenMeat.getAddedProperties().add(wellDoneRoast);
        Ingredient goatMeat = createIngredient("Goat meat", 0.25d,
                new BigDecimal(15), meat, new ArrayList<>());
        Property mediumRoast = createProperty("Medium roast",roast);
        goatMeat.getAddedProperties().add(mediumRoast);
        Type bread = new Type("Bread");
        Ingredient burgerBread = new Ingredient("Burger bread", 0.1d,
                new BigDecimal(5), bread, new ArrayList<>());
        ArrayList<Ingredient> necessaryIngs = new ArrayList<>();
        necessaryIngs.add(burgerBread);
        necessaryIngs.add(burgerBread);
        ArrayList<Type> validTypes = new ArrayList<>();
        validTypes.add(bread);
        validTypes.add(meat);
        DishType burger = new DishType("Burger", necessaryIngs, validTypes,
                new BigDecimal(10),0.2d);
        ArrayList<Ingredient> bigBurgerIngredients = new ArrayList<>();
        bigBurgerIngredients.add(chickenMeat);
        bigBurgerIngredients.add(goatMeat);
        Dish bigBurger = createDish("Big burger",bigBurgerIngredients,burger);
        ArrayList<Ingredient> smallBurgerIngredients = new ArrayList<>();
        smallBurgerIngredients.add(chickenMeat);
        Dish smallBurger = createDish("Small burger",smallBurgerIngredients,burger);
        User user = createUser("IgorAdmin","iA@iA", UserRoles.admin);
        ArrayList<Dish> dishList = new ArrayList<>();
        dishList.add(bigBurger);
        dishList.add(smallBurger);
        Order order = createOrder(dishList,user,"Kek Street 1",new Date());
    }
    */

    @Test
    public void overallTest() throws InterruptedException
    {
        testType();
        testPropertyName();
        testProperty();
        testIngredient();
        testDishType();
        testDish();
        testUser();
        testOrder();
    }

    @Test
    public void testType()
    {
        Type meat = createType("Meat");
        typeRepository.save(meat);
        this.meat = meat;
        Type bread = new Type("Bread");
        typeRepository.save(bread);
        this.bread = bread;
        validTypes.add(bread);
        validTypes.add(meat);
        ArrayList<Type> types = new ArrayList<>();
        types.add(meat);
        types.add(bread);
        assertTrue(typeRepository.findAll().containsAll(types));
    }

    @Test
    public void testPropertyName()
    {
        PropertyName roast = createPropertyName("Roast",meat);
        propertyNameRepository.save(roast);
        this.roast = roast;
        assertTrue(propertyNameRepository.findAll().contains(roast));
    }

    @Test
    public void testProperty()
    {
        Property wellDoneRoast = createProperty("Well done roast",roast);
        Property mediumRoast = createProperty("Medium roast",roast);
        ArrayList<Property> properties = new ArrayList<>();
        properties.add(wellDoneRoast);
        properties.add(mediumRoast);
        this.wellDoneRoast = wellDoneRoast;
        this.mediumRoast = mediumRoast;
        assertTrue(propertyRepository.findAll().containsAll(properties));
    }

    @Test
    public void testIngredient() throws InterruptedException
    {
        Ingredient chickenMeat = new Ingredient("Chicken meat", 0.3d,
                new BigDecimal(10), meat, new ArrayList<>());
        chickenMeat.getAddedProperties().add(wellDoneRoast);
        Ingredient goatMeat = new Ingredient("Goat meat", 0.25d,
                new BigDecimal(15), meat, new ArrayList<>());
        goatMeat.getAddedProperties().add(mediumRoast);
        Ingredient burgerBread = new Ingredient("Burger bread", 0.1d,
                new BigDecimal(5), bread, new ArrayList<>());
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(chickenMeat);
        ingredients.add(goatMeat);
        ingredients.add(burgerBread);
        ingredientRepository.save(chickenMeat);
        ingredientRepository.save(goatMeat);
        ingredientRepository.save(burgerBread);
        Thread.sleep(5000);
        System.out.println(ingredientRepository.findAll());
        assertTrue(ingredientRepository.findAll().containsAll(ingredients));
        necessaryIngs.add(burgerBread);
        bigBurgerIngredients.add(chickenMeat);
        bigBurgerIngredients.add(goatMeat);
        smallBurgerIngredients.add(chickenMeat);
        assertEquals(chickenMeat.getAddedProperties().get(0),
                propertyRepository.getOne(chickenMeat.getAddedProperties().get(0).getId()));
    }

    @Test
    public void testDishType()
    {
        DishType burger = createDishType("Burger", necessaryIngs, validTypes,
                new BigDecimal(10),0.2d);
        this.burger = burger;
        assertTrue(dishTypeRepository.findAll().contains(burger));
    }

    @Test
    public void testDish()
    {
        Dish bigBurger = createDish("Big burger",bigBurgerIngredients,burger);
        Dish smallBurger = createDish("Small burger",smallBurgerIngredients,burger);
        dishList.add(bigBurger);
        dishList.add(smallBurger);
        ArrayList<Dish> dishes = new ArrayList<>();
        dishes.add(bigBurger);
        dishes.add(smallBurger);
        assertTrue(dishRepository.findAll().containsAll(dishes));
    }

    @Test
    public void testUser()
    {
        User user = createUser("IgorAdmin","iA@iA", UserRoles.admin);
        this.user = user;
        assertTrue(userRepository.findAll().contains(user));
    }

    @Test
    public void testOrder()
    {
        Order order = createOrder(dishList,user,"Kek Street 1",new Date());
        assertTrue(orderRepository.findAll().contains(order));
    }



    private DishType createDishType(String burger, ArrayList<Ingredient> necessaryIngs, ArrayList<Type> validTypes, BigDecimal bigDecimal, double baseWeight) {
        DishType dishType = new DishType(burger, necessaryIngs, validTypes, bigDecimal, baseWeight);
        dishTypeRepository.save(dishType);
        return dishType;
    }


    private Type createType(String name) {
        Type type = new Type(name);
        typeRepository.save(type);
        return type;
    }

    /*
    private Ingredient createIngredient(String name, double weight, BigDecimal price, Type type, List<Property> addedProperties) {
        Ingredient ingredient = new Ingredient(name, weight, price, type, addedProperties);
        ingredientRepository.save(ingredient);
        return ingredient;
    }
    */

    private PropertyName createPropertyName(String name, Type type) {
        PropertyName propertyName = new PropertyName(name, type);
        propertyNameRepository.save(propertyName);
        return propertyName;
    }

    private Property createProperty(String name, PropertyName propertyName) {
        Property property = new Property(name, propertyName);
        propertyRepository.save(property);
        return property;
    }

    private User createUser(String name, String email, UserRoles userRole) {
        User user = new User(name, email, userRole);
        userRepository.save(user);
        return user;
    }

    private Order createOrder(List<Dish> dishes, User user, String address, Date time) {
        Order order = new Order(dishes, user, address, time);
        orderRepository.save(order);
        return order;
    }

    private Dish createDish(String name, List<Ingredient> ingredients, DishType dishType) {
        Dish dish = new Dish(name, ingredients, dishType);
        dishRepository.save(dish);
        return dish;
    }

}