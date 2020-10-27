package com.wu.web.service.impl;

import com.wu.common.domain.Order;
import com.wu.web.service.interfaces.OrderService;

import java.util.List;

/**
 * @ClassName OrderImpl
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 4:42 pm
 * @Version 1.0
 **/
public class OrderImpl implements OrderService {



    @Override
    public boolean addOrder(Order order) {
        return false;
    }

    @Override
    public Order queryById(String orderId) {
        return null;
    }

    @Override
    public List<Order> queryOrder() {
        return null;
    }
}
