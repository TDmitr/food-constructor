package main.Controllers;

import main.CustomErrorType;
import main.Entities.IngredientType;
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
public class IngredientTypeController {
    @Autowired
    private IngredientTypeRepository ingredientTypeRepository;

    @GetMapping("/allIngredientTypes")
    public ResponseEntity<List<IngredientType>> listAllIngredientTypes() {
        List<IngredientType> ingredientTypes = ingredientTypeRepository.findAll();
        if (ingredientTypes.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(ingredientTypes);
    }

    @PostMapping("/ingredientType")
    public ResponseEntity<?> createIngredientType(@RequestBody IngredientType ingredientType, UriComponentsBuilder uriComponentsBuilder){
        if(ingredientTypeRepository.findByName(ingredientType.getName()) != null)
            return new ResponseEntity<>(new CustomErrorType("Unable to create. An IngredientType with name " +
                    ingredientType.getName() + " already exist."), HttpStatus.CONFLICT);
        ingredientTypeRepository.save(ingredientType);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/ingredientType/{id}").buildAndExpand(ingredientType.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/ingredientTypes/{id}")
    public ResponseEntity<?> getIngredientTypeById(@PathVariable(value = "id") Long Id) {
        IngredientType ingredientType = ingredientTypeRepository.findById(Id);
        return ingredientType == null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                ResponseEntity.ok(ingredientType);
    }

    @PutMapping("ingredientTypes/{id}")
    public ResponseEntity<?> updateIngredientTypeById(@PathVariable(value = "id") Long Id,
                                     @RequestBody IngredientType ingredientTypeInfo) {

        IngredientType ingredientType = ingredientTypeRepository.findById(Id);
        if(ingredientType == null){
            return new ResponseEntity<>(new CustomErrorType("Unable to update IngredientType with Id " +
                    Id + ". It does not exist."), HttpStatus.CONFLICT);
        }
        else {
            ingredientType.setName(ingredientTypeInfo.getName());
            ingredientType.setImage(ingredientTypeInfo.getImage());
            ingredientType.setDishTypes(ingredientTypeInfo.getDishTypes());
            ingredientType.setIngredients(ingredientTypeInfo.getIngredients());
            ingredientType.setPropertyTypes(ingredientTypeInfo.getPropertyTypes());
            ingredientTypeRepository.save(ingredientType);
            return ResponseEntity.ok(ingredientType);
        }
    }

    @DeleteMapping("ingredientTypes/{id}")
    public ResponseEntity<?> deleteIngredientTypeById(@PathVariable(value = "id") Long Id) {
        IngredientType ingredientType = ingredientTypeRepository.findById(Id);
        if(ingredientType == null){
            return new ResponseEntity<>(new CustomErrorType("Unable to delete IngredientType with Id " +
                    ingredientType.getId() + ". It does not exist."), HttpStatus.CONFLICT);
        }
        ingredientTypeRepository.delete(ingredientType);
        return ResponseEntity.ok().build();
    }


}
