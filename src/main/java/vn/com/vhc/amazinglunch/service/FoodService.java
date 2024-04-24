package vn.com.vhc.amazinglunch.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.vhc.amazinglunch.entity.Food;
import vn.com.vhc.amazinglunch.entity.FoodGroup;
import vn.com.vhc.amazinglunch.entity.Restaurant;
import vn.com.vhc.amazinglunch.respository.FoodRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    //lấy danh sách tất cả các món ăn
    public List<Food> getAllFoods(){
        return foodRepository.findAll();
    }
    //lấy một món ăn bằng id
    public Food getFoodById(Integer food_id){
        return foodRepository.findById(food_id).orElse(null);
    }
    //tạo một món ăn mới
    public Food createFood(Food food){
        return foodRepository.save(food);
    }
    //cập nhật thông tin của một món ăn
    public Food updateFood(Integer food_id, Food foodDetails){
        Food food = foodRepository.findById(food_id).orElse(null);
        if(food != null){
            food.setName(foodDetails.getName());
            food.setPrice(foodDetails.getPrice());

            return foodRepository.save(food);
        }
        return null;
    }
    public void deleteFood(Integer food_id){
        foodRepository.deleteById(food_id);
    }
    public List<Food> findFoodWithFoodId(int foodId) {
        return foodRepository.findFoodWithFoodId(foodId);
    }

    public List<Restaurant> findRestaurantWithRestaurantId(int restaurantId) {
        return foodRepository.findRestaurantWithRestaurantId(restaurantId);
    }

    public List<FoodGroup> findFoodGroupWithFoodGroupId(int foodGroupId) {
        return foodRepository.findFoodGroupWithFoodGroupId(foodGroupId);
    }
    public Food findByName(String name) {
        return foodRepository.findByName(name);
    }
}
