package main.Controllers;

import main.CustomErrorType;
import main.Entities.Ingredient;
import main.Repositories.IngredientRepository;
import main.Repositories.IngredientTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private IngredientTypeRepository ingredientTypeRepository;

    @GetMapping("/allIngredients")
    public ResponseEntity<?> listAllIngredientTypes() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        if (ingredients.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping("/ingredientByIngredientType/{id}")
    public ResponseEntity<?> getIngredientsByIngredientTypeId(@PathVariable(value = "id") Long Id) {
        List<Ingredient> ingredients = ingredientRepository.findByIngredientTypeId(Id);
        return ingredients.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                ResponseEntity.ok(ingredients);
    }

    @GetMapping("/ingredient/{id}")
    public ResponseEntity<?> getIngredientsById(@PathVariable(value = "id") Long Id) {
        Ingredient ingredient = ingredientRepository.findById(Id);
        return ingredient == null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                ResponseEntity.ok(ingredient);
    }

    @PostMapping("/ingredient")
    public ResponseEntity<?> createIngredient(@RequestBody Ingredient ingredient, UriComponentsBuilder uriComponentsBuilder){
        if(ingredientRepository.findByName(ingredient.getName()) != null)
            return new ResponseEntity<>(new CustomErrorType("Unable to create. An ingredient with name " +
                    ingredient.getName() + " already exist."), HttpStatus.CONFLICT);
//        IngredientType ingType = ingredientTypeRepository.findById(ingredient.getIngredientType().getId());
//        if(ingType == null) {
//            ingredient.getIngredientType().addIngredient(ingredient);
//            ingredientTypeRepository.save(ingredient.getIngredientType());
//        }
//        if (!ingType.equals(ingredient.getIngredientType()))
//            return new ResponseEntity<>(new CustomErrorType("Unable to create. An ingredientType with Id " +
//                    ingredient.getIngredientType().getId() + " exists and is different"), HttpStatus.CONFLICT);
//        ingredientTypeRepository.save(ingredient.getIngredientType());
        ingredientRepository.save(ingredient);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/ingredientType/{id}").buildAndExpand(ingredient.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @PutMapping("ingredient/{id}")
    public ResponseEntity<?> updateIngredientById(@PathVariable(value = "id") Long Id,
                                                      @RequestBody Ingredient ingredientInfo) {

        Ingredient ingredient = ingredientRepository.findById(Id);
        if(ingredient == null){
            return new ResponseEntity<>(new CustomErrorType("Unable to update ingredient with Id " +
                    ingredient.getId() + ". It does not exist."), HttpStatus.CONFLICT);
        }
        else {
            ingredient.setName(ingredientInfo.getName());
            ingredient.setWeight(ingredientInfo.getWeight());
            ingredient.setPrice(ingredientInfo.getPrice());
            ingredient.setImage(ingredientInfo.getImage());
            ingredient.setDishTypes(ingredientInfo.getDishTypes());
            ingredient.setDishes(ingredientInfo.getDishes());
            ingredient.setIngredientProperties(ingredientInfo.getIngredientProperties());
            ingredientRepository.save(ingredient);
            return ResponseEntity.ok(ingredient);
        }
    }

    @DeleteMapping("ingredient/{id}")
    public ResponseEntity<?> deleteIngredientTypeById(@PathVariable(value = "id") Long Id) {
        Ingredient ingredient = ingredientRepository.findById(Id);
        if(ingredient == null){
            return new ResponseEntity<>(new CustomErrorType("Unable to delete ingredient with Id " +
                    ingredient.getId() + ". It does not exist."), HttpStatus.CONFLICT);
        }
        ingredientRepository.delete(ingredient);
        return ResponseEntity.ok().build();
    }








}
