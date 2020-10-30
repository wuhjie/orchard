package com.wu.web.controller;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.customer.Customer;
import com.wu.web.dao.CustomerDao;
import com.wu.web.dao.MainOrderDao;
import com.wu.web.service.interfaces.CustomerService;
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
    MainOrderDao mainOrderDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Autowired
    public void setMainOrderDao(MainOrderDao mainOrderDao) {
        this.mainOrderDao = mainOrderDao;
    }

    @RequestMapping("/customer/add")
    public String addCustomer(Customer customer){
        customerDao.addCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("customer/queryById/{customerId}")
    public Customer queryById(@PathVariable("customerId") String customerId) {
        Customer customer = customerDao.queryById(customerId);
        if (customer == null) {
            throw new RuntimeException("fail");
        }
        return customer;
    }

    @GetMapping("/customer")
    public String queryAll(Model model) {
        Collection<Customer> customerCollection = customerDao.queryAll();
        model.addAttribute("customer", customerCollection);
        return "customer/list";
    }

    @GetMapping("/customer/order")
    public String purchase(Model model, List<MainOrder> orders) {
        Collection<MainOrder> mainOrderCollection = mainOrderDao.purchase(orders);
        model.addAttribute("ordersMade", mainOrderCollection);
        return "customer/order";
    }

    @PostMapping("customer/order")
    public String orderFinished(Model model, MainOrder mainOrder) {
        String orderId = mainOrder.getMainOrderId();
        MainOrder newOrder = mainOrderDao.orderFinished(orderId);
        model.addAttribute("orderFinished", newOrder);
        return  "redirect:/customer";
    }

}
