package vn.com.vhc.amazinglunch.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.vhc.amazinglunch.entity.Restaurant;
import vn.com.vhc.amazinglunch.entity.User;
import vn.com.vhc.amazinglunch.respository.RestaurantRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }
    public Restaurant getRestaurantById(Integer restaurant_id){
        return restaurantRepository.findById(restaurant_id).orElse(null);
    }
    public Restaurant createRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }
    public Restaurant updateRestaurant(Integer restaurant_id, Restaurant restaurantDetails){
        Restaurant restaurant = restaurantRepository.findById(restaurant_id).orElse(null);
        if(restaurant != null){
            restaurant.setName(restaurantDetails.getName());
            restaurant.setAddress(restaurantDetails.getAddress());

            return restaurantRepository.save(restaurant);
        }
        return null;
    }
    public void deleteRestaurant(Integer restaurant_id){
        restaurantRepository.deleteById(restaurant_id);
    }
    public List<Restaurant> findRestaurantWithRestaurantId(int restaurantId) {
        return restaurantRepository.findRestaurantWithRestaurantId(restaurantId);
    }

    public List<User> findRestaurantWithUserId(int userId) {
        return restaurantRepository.findRestaurantWithUserId(userId);
    }

    public Restaurant findById(int restaurantId) {
        return restaurantRepository.findById(restaurantId).orElse(null);
    }

    public Restaurant findByName(String name) {
        return restaurantRepository.findByName(name);
    }

}
