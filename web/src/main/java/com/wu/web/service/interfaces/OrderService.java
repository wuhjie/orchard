package com.wu.web.service.interfaces;

import com.wu.common.domain.Order;

import java.util.List;

/**
 * @ClassName OrderService
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 4:38 pm
 * @Version 1.0
 **/
public interface OrderService {

    boolean addOrder(Order order);

    Order queryById(String orderId);

    List<Order> queryOrder();


}
