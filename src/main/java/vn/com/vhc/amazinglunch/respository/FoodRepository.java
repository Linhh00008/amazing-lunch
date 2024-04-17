package vn.com.vhc.amazinglunch.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.vhc.amazinglunch.entity.Food;
import vn.com.vhc.amazinglunch.entity.FoodGroup;
import vn.com.vhc.amazinglunch.entity.Restaurant;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    @Query(value = "select * from foods where food_id = : food_id, restaurant_id = : restaurant_id, foodgroup_id =: foodgroup_id", nativeQuery = true)
    List<Food> findFoodWithFoodId(@Param("food_id") int food_id);

    List<Restaurant> findRestaurantWithRestaurantId(@Param("restaurant_id")int restaurant_id);

    List<FoodGroup> findFoodGroupWithFoodGroupId(@Param("foodgroup_id") int foodgroup_id);

}
