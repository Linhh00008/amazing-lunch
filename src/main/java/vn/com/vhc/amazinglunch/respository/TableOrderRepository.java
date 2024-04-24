package vn.com.vhc.amazinglunch.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.vhc.amazinglunch.entity.Restaurant;
import vn.com.vhc.amazinglunch.entity.TableOrder;

import java.util.List;

@Repository
public interface TableOrderRepository extends JpaRepository<TableOrder, Integer> {
    @Query(value = "select * from tableOrder where tableOrder_id =: tableOrder_id, restaurant_id =: restaurant_id", nativeQuery = true)
    List<TableOrder> findTableOrderWithTableOrderId(@Param("tableOrder_id") int tableOrder_id);

    List<Restaurant> findTableOrderWithRestaurantId(@Param("restaurant_id") int restaurant_id);
    TableOrder findById(TableOrder tableOrder_id);

    TableOrder findByTableNumber(Integer numberCurrentPerson);

    void deleteById(Integer tableOrder_id);
}
