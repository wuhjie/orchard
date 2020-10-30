package com.wu.web.service.impl;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Good;
import com.wu.common.domain.customer.Customer;
import com.wu.web.dao.MainOrderDao;
import com.wu.web.service.interfaces.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName OrderImpl
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 4:42 pm
 * @Version 1.0
 **/
public class OrderImpl implements OrderService {

    private MainOrderDao mainOrderDao;

    @Autowired
    public void setMainOrderDao(MainOrderDao mainOrderDao) {
        this.mainOrderDao = mainOrderDao;
    }

    @Override
    public MainOrder addOrder(MainOrder mainOrder) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.addOrder(mainOrder);
    }

    @Override
    public MainOrder queryByOrderId(String orderId) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.queryByOrderId(orderId);
    }

    @Override
    public List<MainOrder> queryByCustomerId(Customer customer) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.quertAll(customer.getCustomerId());
    }

    @Override
    public List<MainOrder> purchase(List<MainOrder> orders) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.purchase(orders);
    }

    @Override
    public List<MainOrder> subOrderIntoMainOrder(List<MainOrder> orders) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.purchase(orders);
    }

    @Override
    public MainOrder orderFinished(MainOrder mainOrder) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.orderFinished(mainOrder.getMainOrderId());
    }

//    @Override
//    public MainOrder statusChanged(String orderId, MainOrder.subOrder.OrderStatus changedStatus) {
//        setMainOrderDao(mainOrderDao);
//        return mainOrderDao.statusChanged(orderId, changedStatus);
//    }

    @Override
    public MainOrder orderReceived(String orderId) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.orderReceived(orderId);
    }

    @Override
    public MainOrder addToShoppingCart(Good good) {
        return null;
    }
}
