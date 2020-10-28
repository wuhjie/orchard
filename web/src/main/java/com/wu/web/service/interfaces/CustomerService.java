package com.wu.web.service.interfaces;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.customer.Customer;

import java.util.List;

/**
 * @ClassName CustomerService
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 9:24 am
 * @Version 1.0
 **/
public interface CustomerService {

    /**
     *
     * @param customer
     * @return
     */
    boolean addCustomer (Customer customer);

    /**
     *
     * @param CustomerId
     * @return
     */
    Customer queryById (String CustomerId);

    /**
     *
     * @return
     */
    List<Customer> queryAll();

}
