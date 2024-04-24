package vn.com.vhc.amazinglunch.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.vhc.amazinglunch.entity.TableOrder;
import vn.com.vhc.amazinglunch.service.TableOrderService;

import java.util.List;

@RestController
@RequestMapping("/api/tableOrder")
public class TableOrderController {
    private TableOrderService tableOrderService;

    @GetMapping
    public ResponseEntity<List<TableOrder>> getAllTableOrders(){
        List<TableOrder> tableOrders = tableOrderService.getAllTableOrder();
        return new ResponseEntity<>(tableOrders, HttpStatus.OK);
    }

    @GetMapping("/{tableOrder_id}")
    public ResponseEntity<TableOrder> getTableOrderById(@PathVariable("customer_id") Integer customer_id){
        TableOrder tableOrder = tableOrderService.getTableOrderById(customer_id);
        if (tableOrder != null){
            return new ResponseEntity<>(tableOrder, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
