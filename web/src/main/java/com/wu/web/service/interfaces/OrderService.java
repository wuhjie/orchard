package com.wu.web.service.interfaces;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Good;
import com.wu.common.domain.customer.Customer;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName OrderService
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 4:38 pm
 * @Version 1.0
 **/
public interface OrderService {

//    MainOrder.subOrder addOrder(MainOrder mainOrder);

    MainOrder.subOrder queryByOrderId(String orderId);

    List<MainOrder.subOrder> queryAll(Customer customer);

    MainOrder.subOrder purchase(MainOrder.subOrder subOrder);

    MainOrder.subOrder subOrderIntoMainOrder(List<MainOrder.subOrder> orders);
//    MainOrder statusChanged(String orderId, MainOrder.subOrder.OrderStatus changedStatus);

    MainOrder.subOrder inShoppingCart(Good good);

    MainOrder.subOrder orderPending(MainOrder.subOrder subOrder);

    MainOrder.subOrder orderReceived(MainOrder.subOrder subOrder);

    MainOrder.subOrder expressReceived(MainOrder.subOrder subOrder);

    MainOrder.subOrder orderShipping(MainOrder.subOrder subOrder);

    MainOrder.subOrder orderShipped(MainOrder.subOrder subOrder);

    MainOrder.subOrder orderFinished(MainOrder.subOrder subOrder);

    MainOrder.subOrder orderCancelled(MainOrder.subOrder subOrder);

    void removeFromShoppingCart(MainOrder.subOrder subOrder);


}
