package vn.com.vhc.amazinglunch.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.vhc.amazinglunch.service.CustomerService;
import vn.com.vhc.amazinglunch.entity.Customer;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{customer_id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customer_id") Integer customer_id) {
        Customer customer = customerService.getCustomersId(customer_id);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    //cap nhat thong tin cua mot khach hang
    @PutMapping("/{customer_id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customer_id") Integer customer_id, @RequestBody Customer customerDetails) {
        Customer updateCustomer = customerService.updateCustomer(customer_id, customerDetails);
        if (updateCustomer != null) {
            return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //xoa mot khach hang
    @DeleteMapping("/{customer_id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customer_id") Integer customer_id, @RequestBody Customer customerDetails){
        customerService.deleteCustomer(customer_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
