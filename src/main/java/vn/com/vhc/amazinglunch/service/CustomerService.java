package vn.com.vhc.amazinglunch.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.com.vhc.amazinglunch.entity.Customer;
import vn.com.vhc.amazinglunch.entity.TableOrder;
import vn.com.vhc.amazinglunch.respository.CustomerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Customer getCustomersId(Integer customer_id){
        return customerRepository.findById(customer_id).orElse(null);
    }
    public Customer getCustomersEmail(String email){
        return customerRepository.findByEmail(email);
    }
    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public Customer updateCustomer(Integer customer_id, Customer customerDetails){
        Customer customer = customerRepository.findById(customer_id).orElse(null);
        if(customer != null){
            customer.setName(customerDetails.getName());
            customer.setEmail(customerDetails.getEmail());

            return customerRepository.save(customer);
        }
        return null;
    }
    public void deleteCustomer(Integer customer_id){
        customerRepository.deleteById(customer_id);
    }
    public List<Customer> findCustomerWithCustomerId(int customerId) {
        return customerRepository.findCustomerWithCustomerId(customerId);
    }

    public List<TableOrder> findTableOrderWithTableOrderId(int tableOrderId) {
        return customerRepository.findTableOrderWithTableOrderId(tableOrderId);
    }

}
