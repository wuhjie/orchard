package com.wu.web.service.impl;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Good;
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

    @Autowired
    private OrderDao orderDao;

    @Override
    public MainOrder.SubOrder addOrder(MainOrder.SubOrder subOrder) {
        return orderDao.addOrder(subOrder);
    }

    @Autowired
    public void setMainOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public MainOrder.SubOrder queryByOrderId(String orderId) {
        return orderDao.queryByOrderId(orderId);
    }

    @Override
    public MainOrder.SubOrder queryWithItemId(String goodId) {
        return orderDao.queryWithItemId(goodId);
    }

    @Override
    public List<MainOrder.SubOrder> queryAll() {
        return orderDao.queryAll();
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
        return orderDao.inShoppingCart(good);
    }

    //todo
    @Override
    public MainOrder subOrderIntoMainOrder(List<MainOrder.SubOrder> orders) {
        return orderDao.subOrderIntoMainOrder(orders);
    }

    @Override
    public MainOrder.SubOrder orderPending(MainOrder.SubOrder subOrder) {
        return orderDao.orderPending(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.SubOrder orderReceived(MainOrder.SubOrder subOrder) {
        return orderDao.orderReceived(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.SubOrder expressReceived(MainOrder.SubOrder subOrder) {
        return orderDao.expressReceived(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.SubOrder orderShipping(MainOrder.SubOrder subOrder) {
        return orderDao.orderShipping(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.SubOrder orderShipped(MainOrder.SubOrder subOrder) {
        return orderDao.orderShipped(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.SubOrder orderFinished(MainOrder.SubOrder subOrder) {
        return orderDao.orderFinished(subOrder.getSubOrderId());
    }

    @Override
    public MainOrder.SubOrder orderCancelled(MainOrder.SubOrder subOrder) {
        return orderDao.orderCancelled(subOrder.getSubOrderId());
    }

    @Override
    public void removeFromShoppingCart(MainOrder.SubOrder subOrder, String customerId) {
        orderDao.removeFromShoppingCart(subOrder.getSubOrderId(), subOrder.getCustomerId());
    }

    @Override
    public MainOrder.GiftingItem giftPending(MainOrder.SubOrder subOrder) {
        return orderDao.giftPending(subOrder);
    }

    @Override
    public void receivingGift(MainOrder.GiftingItem giftingItem) {
        orderDao.itemIntoPresentGiving(giftingItem);
    }

}
