package vn.com.vhc.amazinglunch.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.vhc.amazinglunch.entity.Restaurant;
import vn.com.vhc.amazinglunch.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/api/controller")
public class RestaurantController {
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> listAll(){
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }
    @GetMapping("/{restaurant_id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("restaurant_id") Integer restaurant_id){
        Restaurant restaurant = restaurantService.getRestaurantById(restaurant_id);
        if(restaurant != null){
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Restaurant> createBooking(@RequestBody Restaurant restaurant) {
        Restaurant createdRestaurat = restaurantService.createRestaurant(restaurant);
        return new ResponseEntity<>(createdRestaurat, HttpStatus.CREATED);
    }
    @PutMapping("/{restaurant_id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("restaurant_id") Integer restaurant_id, @RequestBody Restaurant restaurantDetails){
        Restaurant updateRes = restaurantService.updateRestaurant(restaurant_id, restaurantDetails);
        if(updateRes != null){
            return new ResponseEntity<>(updateRes, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{restaurant_id}")
    public ResponseEntity<Void> deleteRes(@PathVariable("restaurant_id") Integer restaurant_id){
        restaurantService.deleteRestaurant(restaurant_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
