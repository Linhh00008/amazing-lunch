package vn.com.vhc.amazinglunch.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.vhc.amazinglunch.entity.Food;
import vn.com.vhc.amazinglunch.entity.Order;
import vn.com.vhc.amazinglunch.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;

    // Lấy danh sách tất cả các đơn đặt hàng
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Food> orders = orderService.getAllOrders();
        return orders;
    }

    // Lấy đơn đặt hàng bằng ID
    @GetMapping("/{order_id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("order_id") Integer order_id) {
        Order order = orderService.addToOrder(order_id);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Tạo một đơn đặt hàng mới
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.addToOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    // Cập nhật thông tin của một đơn đặt hàng
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Long id, @RequestBody Order orderDetails) {
        Order updatedOrder = orderService.updateOrder(id, orderDetails);
        if (updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Xóa một đơn đặt hàng
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
