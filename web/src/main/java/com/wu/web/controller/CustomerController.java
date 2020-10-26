package com.wu.web.controller;

import com.wu.common.domain.customer.Customer;
import com.wu.web.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @Autowired
    private CustomerService customerService;


//    public void setCustomerService(CustomerService customerService) {
//        this.customerService = customerService;
//    }

//    @GetMapping("/hello")
//    public void helloWorld() {
//        System.out.println("7777");
//    }

//    @RequestMapping("/customer")
//    public String list(Model model) {
//        Collection<Customer> customers = customerService.queryAll();
//        model.addAttribute("customers", customers);
//        return "customers/list";
//    }

    @RequestMapping("/customer/add")
    public boolean addCustomer(Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("customer/queryById/{id}")
    public Customer queryById(@PathVariable("customerId") String customerId) {
        Customer customer = customerService.queryById(customerId);
        if (customer == null) {
            throw new RuntimeException("fail");
        }
        return customer;
    }

    @GetMapping("/customer")
    public List<Customer> queryAll() {
        return customerService.queryAll();
    }
}
