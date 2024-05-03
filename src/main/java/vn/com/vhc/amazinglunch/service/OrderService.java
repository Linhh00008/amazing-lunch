package vn.com.vhc.amazinglunch.service;

import org.springframework.stereotype.Service;
import vn.com.vhc.amazinglunch.entity.Order;
import vn.com.vhc.amazinglunch.respository.FoodRepository;
import vn.com.vhc.amazinglunch.respository.OrderRepository;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    private FoodRepository foodRepository;

    // Get order by id
    public Order getOrderById(Integer orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    // Create new order
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Update existing order
    public Order updateOrder(Integer orderId, Order orderDetails) {
        Order existingOrder = getOrderById(orderId);
        if (existingOrder != null) {
            // Update order details
            existingOrder.setUpdate_at(orderDetails.getUpdate_at());
            // You can update other properties here as well
            return orderRepository.save(existingOrder);
        } else {
            return null; // Or throw an exception as needed
        }
    }

    // Delete order
    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
