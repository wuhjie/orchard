package com.wu.web.controller;

import com.wu.common.domain.customer.Customer;
import com.wu.web.dao.CustomerDao;
import com.wu.web.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


//    CustomerService customerService;
//
//    @Autowired
//    public void setCustomerService (CustomerService customerService) {
//        this.customerService = customerService;
//    }

    CustomerDao customerDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


//    @RequestMapping("/customer/add")
//    public boolean addCustomer(Customer customer) {
//        return customerDao.addCustomer(customer);
//    }

    public String add(Model model){
        Collection<>
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
}
