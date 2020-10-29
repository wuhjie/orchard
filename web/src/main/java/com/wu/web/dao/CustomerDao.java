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

    boolean addCustomer(Customer customer);

    Customer queryById(String customerId);

    List<Customer> queryAll();


    List<MainOrder> purchase(List<MainOrder> orders);

    MainOrder orderFinished(MainOrder mainOrder);
}
