package com.wu.web.dao;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.customer.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @ClassName CustomerDao
 * @Description
 * @Author wuhjie
 * @Data 2020/10/22 11:01 am
 * @Version 1.0
 **/

@Mapper
@Repository
public interface CustomerDao {

    /**
     *
     * @param customer
     * @return
     */
    boolean addCustomer(Customer customer);

    /**
     *
     * @param customerId
     * @return
     */
    Customer queryById(String customerId);

    /**
     *
     * @return
     */
    List<Customer> queryAll();

    /**
     *
     * @param mainOrder
     * @return
     */
    MainOrder purchase(MainOrder mainOrder);


}
