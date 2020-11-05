package com.wu.web.service.impl;

import com.wu.common.domain.customer.Customer;
import com.wu.web.dao.CustomerDao;
import com.wu.web.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CustomerImpl
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 9:30 am
 * @Version 1.0
 **/

@Service
public class CustomerImpl implements CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        setCustomerDao(customerDao);

        return customerDao.addCustomer(customer);
    }

    @Override
    public Customer queryByCustomerId(String customerId) {
        setCustomerDao(customerDao);
        return customerDao.queryByCustomerId(customerId);
    }

    @Override
    public Customer queryByCustomerName(String customerName) {
        return null;
    }

    @Override
    public List<Customer> queryAll() {
        setCustomerDao(customerDao);
        return customerDao.queryAllCustomer();
    }

    @Override
    public Customer updateCustomerInfo(Customer customer) {
        setCustomerDao(customerDao);
        return customerDao.updateCustomerInfo(customer);
    }


}
