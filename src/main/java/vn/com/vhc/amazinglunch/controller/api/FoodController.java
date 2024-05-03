package vn.com.vhc.amazinglunch.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.vhc.amazinglunch.entity.Food;
import vn.com.vhc.amazinglunch.service.FoodService;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {
    private FoodService foodService;

    @GetMapping
    public ResponseEntity<List<Food>> getAllFoods(){
        List<Food> foods = foodService.getAllFoods();
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }
    @GetMapping("/{food_id}")
    public ResponseEntity<Food> getFoodById(@PathVariable("food_id") Integer food_id){
        Food food = foodService.getFoodById(food_id);
        if (food != null){
            return new ResponseEntity<>(food, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody Food food){
        Food createdFood = foodService.createFood(food);
        return new ResponseEntity<>(createdFood, HttpStatus.CREATED);
    }

    @PutMapping("/{food_id}")
    public ResponseEntity<Food> updateFood(@PathVariable("id") Integer food_id, @RequestBody Food foodDetails){
        Food updateFood = foodService.updateFood(food_id, foodDetails);
        if(updateFood != null){
            return new ResponseEntity<>(updateFood, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{food_id}")
    public ResponseEntity<Void> deleteFood(@PathVariable("food_id") Integer food_id){
        foodService.deleteFood(food_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
