package com.wu.web.service.impl;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Good;
import com.wu.common.domain.customer.Customer;
import com.wu.web.dao.MainOrderDao;
import com.wu.web.service.interfaces.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OrderImpl
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 4:42 pm
 * @Version 1.0
 **/

@Service
public class OrderImpl implements OrderService {

    private MainOrderDao mainOrderDao;

    @Autowired
    public void setMainOrderDao(MainOrderDao mainOrderDao) {
        this.mainOrderDao = mainOrderDao;
    }

    @Override
    public MainOrder.subOrder addOrder(MainOrder mainOrder) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.addOrder(mainOrder);
    }

    @Override
    public MainOrder.subOrder queryByOrderId(String orderId) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.queryByOrderId(orderId);
    }

    @Override
    public List<MainOrder.subOrder> queryByCustomerId(Customer customer) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.quertAll(customer.getCustomerId());
    }

    @Override
    public List<MainOrder.subOrder> purchase(List<MainOrder> orders) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.purchase(orders);
    }

    @Override
    public List<MainOrder> subOrderIntoMainOrder(List<MainOrder> orders) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.purchase(orders);
    }

    @Override
    public MainOrder inShoppingCart(Good good) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.inShoppingCart(good);
    }

    @Override
    public MainOrder orderPending(MainOrder subOrder) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.orderPending(subOrder.getMainOrderId());
    }

    @Override
    public MainOrder orderReceived(MainOrder subOrder) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.orderReceived(subOrder.getMainOrderId());
    }

    @Override
    public MainOrder expressReceived(MainOrder.subOrder subOrder) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.expressReceived(subOrder.getMainOrderId());
    }

    @Override
    public MainOrder orderShipping(MainOrder.subOrder subOrder) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.orderShipping(subOrder.getMainOrderId());
    }

    @Override
    public MainOrder orderShipped(MainOrder.subOrder subOrder) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.orderShipped(subOrder.getMainOrderId());
    }

    @Override
    public MainOrder orderFinished(MainOrder.subOrder subOrder) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.orderFinished(subOrder.getMainOrderId());
    }

    @Override
    public MainOrder orderCancelled(MainOrder.subOrder subOrder) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.orderCancelled(subOrder.getMainOrderId());
    }

    @Override
    public void removeFromShoppingCart(MainOrder.subOrder subOrder) {
        mainOrderDao.removeFromShoppingCart(subOrder.getSubOrderId());
    }
}
