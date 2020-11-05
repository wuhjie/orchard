package com.wu.web.service.interfaces;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Good;
import com.wu.common.domain.customer.Customer;
import org.jboss.jandex.Main;

import java.util.List;

/**
 * @ClassName OrderService
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 4:38 pm
 * @Version 1.0
 **/
public interface OrderService {

//    MainOrder.subOrder addOrder(MainOrder mainOrder);

    MainOrder.SubOrder queryByOrderId(String orderId);

    List<MainOrder.SubOrder> queryAll(Customer customer);

    MainOrder.SubOrder purchase(MainOrder.SubOrder subOrder);

    MainOrder subOrderIntoMainOrder(List<MainOrder.SubOrder> orders);
//    MainOrder statusChanged(String orderId, MainOrder.subOrder.OrderStatus changedStatus);

    MainOrder.SubOrder inShoppingCart(Good good);

    MainOrder.SubOrder orderPending(MainOrder.SubOrder subOrder);

    MainOrder.SubOrder orderReceived(MainOrder.SubOrder subOrder);

    MainOrder.SubOrder expressReceived(MainOrder.SubOrder subOrder);

    MainOrder.SubOrder orderShipping(MainOrder.SubOrder subOrder);

    MainOrder.SubOrder orderShipped(MainOrder.SubOrder subOrder);

    MainOrder.SubOrder orderFinished(MainOrder.SubOrder subOrder);

    MainOrder.SubOrder orderCancelled(MainOrder.SubOrder subOrder);

    void removeFromShoppingCart(MainOrder.SubOrder subOrder, String customerId);

    MainOrder.GiftingItem giftPending (MainOrder.SubOrder subOrder);

    void receivingGift (MainOrder.GiftingItem giftingItem);


}
