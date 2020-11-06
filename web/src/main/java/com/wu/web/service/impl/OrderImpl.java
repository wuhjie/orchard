package com.wu.web.service.impl;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Good;
import com.wu.common.domain.customer.Customer;
import com.wu.web.dao.OrderDao;
import com.wu.web.service.interfaces.OrderService;
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

    private OrderDao orderDao;

    @Autowired
    public void setMainOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public MainOrder.SubOrder queryByOrderId(String orderId) {
        setMainOrderDao(orderDao);
        return orderDao.queryByOrderId(orderId);
    }

    @Override
    public List<MainOrder.SubOrder> queryAllWithCustomerId(String customerId) {
        setMainOrderDao(orderDao);
        return orderDao.queryAllWithCustomerId(customerId);
    }

    @Override
    public MainOrder.SubOrder purchase(MainOrder.SubOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.purchase(subOrder);
    }


    @Override
    public MainOrder.SubOrder inShoppingCart(Good good) {
        setMainOrderDao(orderDao);
        return orderDao.inShoppingCart(good);
    }

    //todo
    @Override
    public MainOrder subOrderIntoMainOrder(List<MainOrder.SubOrder> orders) {
        setMainOrderDao(orderDao);
        orderDao.subOrderIntoMainOrder(orders);
        return orderDao.subOrderIntoMainOrder(orders);
    }

    @Override
    public MainOrder.SubOrder orderPending(MainOrder.SubOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.orderPending(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.SubOrder orderReceived(MainOrder.SubOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.orderReceived(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.SubOrder expressReceived(MainOrder.SubOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.expressReceived(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.SubOrder orderShipping(MainOrder.SubOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.orderShipping(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.SubOrder orderShipped(MainOrder.SubOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.orderShipped(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.SubOrder orderFinished(MainOrder.SubOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.orderFinished(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.SubOrder orderCancelled(MainOrder.SubOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.orderCancelled(subOrder.getSubOrderId());
    }

    @Override
    public void removeFromShoppingCart(MainOrder.SubOrder subOrder, String customerId) {
        setMainOrderDao(orderDao);
        orderDao.removeFromShoppingCart(subOrder.getSubOrderId(), subOrder.getCustomerId());
    }

    @Override
    public MainOrder.GiftingItem giftPending(MainOrder.SubOrder subOrder) {
        setMainOrderDao(orderDao);
        return orderDao.giftPending(subOrder);
    }

    @Override
    public void receivingGift(MainOrder.GiftingItem giftingItem) {
        setMainOrderDao(orderDao);
        orderDao.itemIntoPresentGiving(giftingItem);
    }
}
