package com.wu.web.controller;

import com.wu.common.domain.ApiResponse;
import com.wu.common.domain.MainOrder;
import com.wu.common.domain.customer.Customer;
import com.wu.web.service.interfaces.CustomerService;
import com.wu.web.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RequestMapping("/customer")
@RestController
public class CustomerController {

//    CustomerDao customerDao;
//    OrderDao orderDao;

    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;

    //create customer
    @RequestMapping("/add")
    public ApiResponse<Customer> addCustomer(Customer customer){
        Customer newCustomer = customerService.addCustomer(customer);
        return ApiResponse.ok(newCustomer);
    }

    @GetMapping("/queryById/{customerId}")
    public ApiResponse<Customer> queryById(@PathVariable("customerId") String customerId) {
        Customer customer = customerService.queryByCustomerId(customerId);
        if (customer == null) {
            throw new RuntimeException("fail");
        }
        return ApiResponse.ok(customer);
    }
    /**
     * todo use purchase and subOrderIntoMainOrder
     */

    @GetMapping("/order")
    public ApiResponse<Collection<MainOrder.SubOrder>> purchase(List<MainOrder.SubOrder> orders) {

        List<MainOrder.SubOrder> newOrderCollection = new ArrayList<>();
        for (MainOrder.SubOrder order : orders) {
            newOrderCollection.add(orderService.purchase(order));
        }
        return ApiResponse.ok(newOrderCollection);
    }

    @PostMapping("/order")
    public ApiResponse<MainOrder> orderFinished(MainOrder.SubOrder subOrder) {
        MainOrder.SubOrder newOrder = orderService.orderFinished(subOrder);
        return ApiResponse.ok(newOrder);
    }

    //todo
    public ApiResponse<Customer> updateCustomerInfo(Customer customer) {
        customerService.updateCustomerInfo(customer);
        return ApiResponse.ok();
    }

    @RequestMapping("/list")
    public void firstAttempt() {
        System.out.println(777);
    }

//    public ApiResponse<Customer> displayCustomerInfo(String customerId) {
//        Customer currentCustomer = customerService.queryByCustomerId(customerId);
//
//        return String.format("customer/personalPortal%s", customerId);
//    }

}
