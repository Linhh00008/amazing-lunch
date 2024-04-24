package vn.com.vhc.amazinglunch.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.vhc.amazinglunch.entity.Restaurant;
import vn.com.vhc.amazinglunch.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Query(value = "select * from restaurants where restaurant_id =: restaurant_id, user_id =: user_id", nativeQuery = true)
    List<Restaurant> findRestaurantWithRestaurantId(@Param("restaurant_id") int restaurant_id);

    List<User> findRestaurantWithUserId(@Param("user_id") int user_id);

    Restaurant findById(Restaurant restaurant_id);

    Restaurant findByName(String name);

    void deleteById(Integer restaurant_id);
}
