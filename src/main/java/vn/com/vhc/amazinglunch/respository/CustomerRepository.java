package vn.com.vhc.amazinglunch.respository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.vhc.amazinglunch.entity.Customer;
import vn.com.vhc.amazinglunch.entity.TableOrder;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customers where customer_id =: customer_id, tableOrder_id =: tableOrder_id)", nativeQuery = true)
    List<Customer> findCustomerWithCustomerId(@Param("customer_id") int customer_id);

    List<TableOrder> findTableOrderWithTableOrderId(@Param("tableOrder_id") int tableOrder_id);

    Optional<Customer> findById(Integer customer_id);

    Customer findByEmail(String email);

    Customer save(Customer customer);

    void deleteById(Integer customer_id);
}
