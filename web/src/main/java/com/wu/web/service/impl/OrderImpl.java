package com.wu.web.service.impl;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Good;
import com.wu.common.domain.customer.Customer;
import com.wu.web.dao.OrderDao;
import com.wu.web.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName OrderImpl
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 4:42 pm
 * @Version 1.0
 **/

@Service
public class OrderImpl implements OrderService {

    private OrderDao orderDao;

    @Autowired
    public void setMainOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

//    @Override
//    public MainOrder.subOrder addOrder(MainOrder.subOrder subOrder) {
//        setMainOrderDao(mainOrderDao);
//        return mainOrderDao.addOrder(subOrder);
//    }

    @Override
    public MainOrder.subOrder queryByOrderId(String orderId) {
        setMainOrderDao(orderDao);
        return orderDao.queryByOrderId(orderId);
    }

    @Override
    public List<MainOrder.subOrder> queryAll(Customer customer) {
        setMainOrderDao(orderDao);
        return orderDao.quertAll(customer.getCustomerId());
    }

    @Override
    public MainOrder.subOrder purchase(MainOrder.subOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.purchase(subOrder);
    }

    @Override
    public MainOrder.subOrder subOrderIntoMainOrder(List<MainOrder.subOrder> orders) {
        return null;
    }


    @Override
    public MainOrder.subOrder inShoppingCart(Good good) {
        setMainOrderDao(orderDao);
        return orderDao.inShoppingCart(good);
    }

    @Override
    public MainOrder.subOrder orderPending(MainOrder.subOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.orderPending(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.subOrder orderReceived(MainOrder.subOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.orderReceived(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.subOrder expressReceived(MainOrder.subOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.expressReceived(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.subOrder orderShipping(MainOrder.subOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.orderShipping(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.subOrder orderShipped(MainOrder.subOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.orderShipped(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.subOrder orderFinished(MainOrder.subOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.orderFinished(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.subOrder orderCancelled(MainOrder.subOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.orderCancelled(subOrder.getSubOrderId());
    }

    @Override
    public void removeFromShoppingCart(MainOrder.subOrder subOrder) {
        orderDao.removeFromShoppingCart(subOrder.getSubOrderId());
    }
}
