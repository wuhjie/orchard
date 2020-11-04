package com.wu.web.controller;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.customer.Customer;
import com.wu.web.dao.CustomerDao;
import com.wu.web.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public String addCustomer(Customer customer){
        customerDao.addCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("customer/queryById/{customerId}")
    public Customer queryById(@PathVariable("customerId") String customerId) {
        Customer customer = customerDao.queryByCustomerId(customerId);
        if (customer == null) {
            throw new RuntimeException("fail");
        }
        return customer;
    }

    @GetMapping("/customer")
    public String queryAll(Model model) {
        Collection<Customer> customerCollection = customerDao.queryAllCustomer();
        model.addAttribute("customer", customerCollection);
        return "customer/list";
    }

    /**
     * todo use purchase and subOrderIntoMainOrder
     */

    @GetMapping("/customer/order")
    public String purchase(Model model, List<MainOrder.subOrder> orders) {

        List<MainOrder.subOrder> newOrderCollection = new ArrayList<>();
        for (MainOrder.subOrder order : orders) {
            newOrderCollection.add(orderDao.purchase(order));
        }
        model.addAttribute("ordersMade", newOrderCollection);
        return "customer/order";
    }

    @PostMapping("customer/order")
    public String orderFinished(Model model, MainOrder.subOrder subOrder) {
        MainOrder.subOrder newOrder = orderDao.orderFinished(subOrder.getSubOrderId());
        model.addAttribute("orderFinished", newOrder);
        return  "redirect:/customer";
    }

}
