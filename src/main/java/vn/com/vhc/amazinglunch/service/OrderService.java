package vn.com.vhc.amazinglunch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.vhc.amazinglunch.entity.Order;
import vn.com.vhc.amazinglunch.entity.TableOrder;
import vn.com.vhc.amazinglunch.respository.FoodRepository;
import vn.com.vhc.amazinglunch.respository.OrderRepository;
import vn.com.vhc.amazinglunch.entity.Food;
import vn.com.vhc.amazinglunch.entity.OrderItem;

import java.util.List;

@Service

public class OrderService {
    private OrderRepository orderRepository;

    private FoodRepository foodRepository;

    public List<Food> getAllOrders(){
        return foodRepository.findAll();
    }
    public Order addToOrder(Integer food_id,OrderItem orderItem) {
        boolean foodExists = foodRepository.existsById(Math.toIntExact(food_id));
        if (!foodExists) {
            throw new NotFoundException("Food not found");
        }
        //người dùng không có đơn hàng, thì tạo mới đơn hàng
        Order userOrder = (Order) orderRepository.findOrderWithCustomerId(Math.toIntExact(food_id));
        if(userOrder == null){
            userOrder = new Order();
            //thông tin khách hàng đang thiếu trong đoạn mã
            userOrder = orderRepository.save(userOrder);
        }
        return userOrder;
    }
    public Order listAll(Integer Order){
        return orderRepository.findAll(Order);
    }
    public class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }
    public List<Order> findOrderWithOrderId(int orderId) {
        return orderRepository.findOrderWithOrderId(orderId);
    }

    public List<Food> findOrderWithFoodId(int foodId) {
        return orderRepository.findOrderWithFoodId(foodId);
    }

    public List<TableOrder> findOrderWithTableOrderId(int tableOrderId) {
        return orderRepository.findOrderWithTableOrderId(tableOrderId);
    }

}
