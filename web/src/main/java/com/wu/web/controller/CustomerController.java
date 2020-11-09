package com.wu.web.controller;

import com.wu.common.domain.ApiResponse;
import com.wu.common.domain.MainOrder;
import com.wu.common.domain.customer.Customer;
import com.wu.web.dao.CustomerDao;
import com.wu.web.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName CustomerController
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 9:23 am
 * @Version 1.0
 **/

@RestController
public class CustomerController {

    CustomerDao customerDao;
    OrderDao orderDao;


    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Autowired
    public void setMainOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    //create customer
    @RequestMapping("/customer/add")
    public ApiResponse<Customer> addCustomer(Customer customer){
        Customer newCustomer = customerDao.addCustomer(customer);
        return ApiResponse.ok(newCustomer);
    }

    @GetMapping("customer/queryById/{customerId}")
    public ApiResponse<Customer> queryById(@PathVariable("customerId") String customerId) {
        Customer customer = customerDao.queryByCustomerId(customerId);
        if (customer == null) {
            throw new RuntimeException("fail");
        }
        return ApiResponse.ok(customer);
    }

    @GetMapping("/customer")
    public ApiResponse<Collection<Customer>> queryAll() {
        Collection<Customer> customerCollection = customerDao.queryAllCustomer();
        return ApiResponse.ok(customerCollection);
    }

    /**
     * todo use purchase and subOrderIntoMainOrder
     */

    @GetMapping("/customer/order")
    public ApiResponse<Collection<MainOrder.SubOrder>> purchase(List<MainOrder.SubOrder> orders) {

        List<MainOrder.SubOrder> newOrderCollection = new ArrayList<>();
        for (MainOrder.SubOrder order : orders) {
            newOrderCollection.add(orderDao.purchase(order));
        }
        return ApiResponse.ok(newOrderCollection);
    }

    @PostMapping("customer/order")
    public ApiResponse<MainOrder> orderFinished(MainOrder.SubOrder subOrder) {
        MainOrder.SubOrder newOrder = orderDao.orderFinished(subOrder.getSubOrderId());
        return ApiResponse.ok(newOrder);
    }

    //todo
    public ApiResponse<Customer> updateCustomerInfo(Customer customer) {
        customerDao.updateCustomerInfo(customer);
        return ApiResponse.ok();
    }

//    public ApiResponse<Customer> displayCustomerInfo(String customerId) {
//        Customer currentCustomer = customerDao.queryByCustomerId(customerId);
//
//        return String.format("customer/personalPortal%s", customerId);
//    }

}
