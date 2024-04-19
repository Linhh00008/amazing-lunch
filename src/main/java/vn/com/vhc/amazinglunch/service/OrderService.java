package vn.com.vhc.amazinglunch.service;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import vn.com.vhc.amazinglunch.entity.Order;
import vn.com.vhc.amazinglunch.respository.FoodRepository;
import vn.com.vhc.amazinglunch.respository.OrderRepository;
import vn.com.vhc.amazinglunch.entity.Food;
import vn.com.vhc.amazinglunch.entity.OrderItem;

import java.util.List;

@Service

public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> getMenu(){
        return foodRepository.findAll();
    }
    public Order addToOrder(Long food_id,OrderItem orderItem) {
        boolean foodExists = foodRepository.existsById(Math.toIntExact(food_id));
        if (!foodExists) {
            throw new NotFoundException("Food not found");
        }
        Order userOrder = orderRepository.findOrderWithCustomerId(orderItem.getOrder().getCustomer().getId());
    }
    public class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }

}
