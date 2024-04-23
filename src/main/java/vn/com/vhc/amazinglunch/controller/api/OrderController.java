package vn.com.vhc.amazinglunch.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.vhc.amazinglunch.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private OrderService orderService;



}
