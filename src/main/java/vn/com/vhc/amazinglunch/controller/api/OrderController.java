package vn.com.vhc.amazinglunch.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Lấy đơn đặt hàng bằng ID
    @GetMapping("/{order_id}")
    public Order getOrderById(@PathVariable("order_id") Integer order_id) {
        return orderService.getOrderById(order_id);
    }

    // Tạo một đơn đặt hàng mới
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    // Cập nhật thông tin của một đơn đặt hàng
    @PutMapping("/{order_id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("order_id") Integer order_id, @RequestBody Order orderDetails) {
        Order updatedOrder = orderService.updateOrder(order_id, orderDetails);
        if (updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Xóa một đơn đặt hàng
    @DeleteMapping("/{order_id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("order_id") Integer order_id) {
        orderService.deleteOrder(order_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
