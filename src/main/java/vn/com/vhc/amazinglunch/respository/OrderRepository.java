package vn.com.vhc.amazinglunch.respository;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.vhc.amazinglunch.entity.Customer;
import vn.com.vhc.amazinglunch.entity.Food;
import vn.com.vhc.amazinglunch.entity.Order;
import vn.com.vhc.amazinglunch.entity.TableOrder;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select * from orders where order_id = : order_id, food_id = : food_id, tableOrder_id = : tableOrder_id, customer_id =: customer_id", nativeQuery = true)
    List<Order> findOrderWithOrderId(@Param("order_id") int order_id);

    List<Food> findOrderWithFoodId(@Param("food_id") int food_id);

    List<TableOrder> findOrderWithTableOrderId(@Param("tableOrder_id") int tableOrder_id);

    List<Customer> findOrderWithCustomerId(@Param("customer_id") int customer_id);

    Order findAll(Integer order);
    Order findById(int order_id);

    Order save(Order order);

    Order saveAndFlush(Order order);

    void delete(Order order);
}
