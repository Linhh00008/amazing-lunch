package vn.com.vhc.amazinglunch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.vhc.amazinglunch.entity.Customer;
import vn.com.vhc.amazinglunch.entity.Restaurant;
import vn.com.vhc.amazinglunch.entity.TableOrder;
import vn.com.vhc.amazinglunch.respository.TableOrderRepository;

import java.util.List;

@Service
public class TableOrderService {
    @Autowired
    private TableOrderRepository tableOrderRepository;

    public List<TableOrder> getAllTableOrder(){
        return tableOrderRepository.findAll();
    }
    public TableOrder creatrTableOrder(TableOrder tableOrder){
        return tableOrderRepository.save(tableOrder);
    }
    public TableOrder updateTableOrder(Integer tableOrder_id, TableOrder tableOrderDetails) {
        TableOrder tableOrder = tableOrderRepository.findById(tableOrder_id).orElse(null);
        if (tableOrder != null) {
            tableOrder.setNumberCurrentPerson(tableOrderDetails.getNumberCurrentPerson());
            // Cập nhật các thông tin khác nếu cần thiết
            return tableOrderRepository.save(tableOrder);
        }
        return null;
    }
    public void deleteTableOrderById(Integer tableOrder_id) {
        tableOrderRepository.deleteById(tableOrder_id);
    }

    public TableOrder getTableOrderById(Integer customerId) {
        return tableOrderRepository.findById(customerId).orElse(null);
    }
    public TableOrder getTableOrderByTableNumber(Integer numberCurrentPerson){
        return tableOrderRepository.findByTableNumber(numberCurrentPerson);
    }
    public List<TableOrder> findTableOrderWithTableOrderId(int tableOrderId) {
        return tableOrderRepository.findTableOrderWithTableOrderId(tableOrderId);
    }

    public List<Restaurant> findTableOrderWithRestaurantId(int restaurantId) {
        return tableOrderRepository.findTableOrderWithRestaurantId(restaurantId);
    }
}
