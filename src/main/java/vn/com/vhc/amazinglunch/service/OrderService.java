package vn.com.vhc.amazinglunch.service;

import org.springframework.beans.factory.annotation.Autowired;
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
        //người dùng không có đơn hàng, thì tạo mới đơn hàng
        Order userOrder = (Order) orderRepository.findOrderWithCustomerId(Math.toIntExact(food_id));
        if(userOrder == null){
            userOrder = new Order();
            //thông tin khách hàng đang thiếu trong đoạn mã
            userOrder = orderRepository.save(userOrder);
        }
        return userOrder;
    }
    public class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }

}
