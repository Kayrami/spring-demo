package kaurami.me.t.springdemo.repository;

import kaurami.me.t.springdemo.tacos.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

    
}
