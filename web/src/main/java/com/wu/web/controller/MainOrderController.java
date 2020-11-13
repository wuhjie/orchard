package com.wu.web.controller;

import com.wu.common.domain.ApiResponse;
import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Good;
import com.wu.web.service.interfaces.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName MainOrderController
 * @Description
 * @Author wuhjie
 * @Data 2020/10/28 3:18 pm
 * @Version 1.0
 * todo reassure the status
 **/

@RestController
@Slf4j
@RequestMapping("/order")
public class MainOrderController {

    OrderService orderService;

    @Autowired
   

    @RequestMapping("/add")
    public ApiResponse<MainOrder.SubOrder> addOrder(MainOrder.SubOrder subOrder) {
        MainOrder.SubOrder newSubOrder = orderService.addOrder(subOrder);
        return ApiResponse.ok(newSubOrder);
    }

    @GetMapping("/queryById/{orderId}")
    public ApiResponse<MainOrder.SubOrder> queryByOrderId(String orderId) {
        MainOrder.SubOrder subOrder = orderService.queryByOrderId(orderId);
        if (subOrder == null) {
            return ApiResponse.error(3, "order not found");
        }
        //todo
        return ApiResponse.ok(subOrder);
    }

    @GetMapping("/queryByCustomerId/{customerId}")
    public ApiResponse<List<MainOrder.SubOrder>> queryAll( String customerId) {
        List<MainOrder.SubOrder> subOrderCollection = orderService.queryAllWithCustomerId(customerId);
        //todo
        return ApiResponse.ok(subOrderCollection);
    }

    @GetMapping("/shoppingCart")
    public ApiResponse<MainOrder.SubOrder> inShoppingCart(Good good) {
        MainOrder.SubOrder subOrder = orderService.inShoppingCart(good);
        return ApiResponse.ok(subOrder);
    }

    @GetMapping("/removeFromShoppingCart")
    public ApiResponse<List<MainOrder.SubOrder>> removeFromShoppingCart(String subOrderId, String customerId) {
        orderService.removeFromShoppingCart(orderService.queryByOrderId(subOrderId), customerId);
        List<MainOrder.SubOrder> newShoppingCart = orderService.queryAllWithCustomerId(subOrderId);
        return ApiResponse.ok(newShoppingCart);
    }

    @GetMapping("/purchasing")
    public ApiResponse<MainOrder> purchaseAndOrderIntoMainOrder(List<MainOrder.SubOrder> subOrders) {
        List<MainOrder.SubOrder> newSubOrders = new ArrayList<>();
        for (MainOrder.SubOrder subOrder : subOrders) {
            newSubOrders.add(orderService.purchase(subOrder));
        }
        MainOrder orders = orderService.subOrderIntoMainOrder(newSubOrders);
        return ApiResponse.ok(orders);
    }

    //todo
    public ApiResponse<MainOrder.SubOrder> orderPending(MainOrder.SubOrder subOrder) {
        MainOrder.SubOrder newOrder = orderService.orderPending(subOrder);
        return ApiResponse.ok(newOrder);
    }

    public ApiResponse<MainOrder.SubOrder> orderReceived( MainOrder.SubOrder subOrder) {
        MainOrder.SubOrder newOrder = orderService.orderReceived(subOrder);
        return ApiResponse.ok(newOrder);
    }

    public ApiResponse<MainOrder.SubOrder> expressReceived(MainOrder.SubOrder subOrder) {
        MainOrder.SubOrder newOrder = orderService.expressReceived(subOrder);
        return ApiResponse.ok(newOrder);
    }

    /**
    *todo ?
    *done every 1am on Sundays
     **/
    @Scheduled(cron = "0 0 1 ? * L")
    public ApiResponse<List<MainOrder.SubOrder>> orderReceived() {
        try {
            List<MainOrder.SubOrder> subOrders = orderService.queryAll();
            List<MainOrder.SubOrder> receivedOrders = subOrders.stream()
                    .filter(subOrder -> subOrder.getOrderStatus() == MainOrder.SubOrder.OrderStatus.orderReceived)
                    .collect(Collectors.toList());
            for (MainOrder.SubOrder receivedOrder : receivedOrders) {
                receivedOrder.setOrderStatus(MainOrder.SubOrder.OrderStatus.orderFinished);
            }
            return ApiResponse.ok(receivedOrders);

        } catch (Exception e) {
            return ApiResponse.error(-3, "order not found");
        }
    }

    //todo
    public ApiResponse<MainOrder.SubOrder> orderCancelled(MainOrder.SubOrder subOrder) {
        MainOrder.SubOrder newOrder = orderService.orderCancelled(subOrder);
        return ApiResponse.ok(newOrder);
    }

    /**
     * auto check for unpaid items
     */
    @Scheduled(cron = "0 0 1 ? * L")
    public ApiResponse<List<MainOrder.SubOrder>> autoCheckForUnpaidOrder() {
        try {
            List<MainOrder.SubOrder> subOrders = orderService.queryAll();
            List<MainOrder.SubOrder> pendingOrders = subOrders.stream()
                    .filter(subOrder -> subOrder.getOrderStatus() == MainOrder.SubOrder.OrderStatus.orderPending)
                    .collect(Collectors.toList());
            for (MainOrder.SubOrder pendingOrder : pendingOrders) {
                pendingOrder.setOrderStatus(MainOrder.SubOrder.OrderStatus.orderCancelled);
            }
            return ApiResponse.ok(pendingOrders);
        } catch (Exception e) {
            return ApiResponse.error(-3, "something happened");
        }
    }

    //todo
    //set the status in suborder into frozen and add it into the giftitem table
    public ApiResponse<MainOrder.SubOrder> giftPending(MainOrder.SubOrder subOrder) {
        MainOrder.GiftingItem giftingOrder = orderService.giftPending(subOrder);
        //the order is frozen in this process
        subOrder.setOrderStatus(MainOrder.SubOrder.OrderStatus.orderFrozen);
        //todo add order into the present gifting list
        MainOrder.GiftingItem giftingItem = orderService.giftPending(subOrder);
        return ApiResponse.ok(giftingItem);
    }

    //todo
    public ApiResponse<MainOrder.SubOrder> giftReceiving(MainOrder.GiftingItem giftingItem) {
        // add the order into the presentGiving table
        orderService.receivingGift(giftingItem);
        String senderId = giftingItem.getSenderId();
        //making giftItem as a order and add it back to the sender orders
        // suborderId + customerId
        orderService.removeFromShoppingCart(orderService.queryWithItemId(giftingItem.getItemId()), giftingItem.getSenderId());
        MainOrder.SubOrder addedOrder =  orderService.addOrder(orderService.queryByOrderId(giftingItem.getItemId()));
        return ApiResponse.ok(addedOrder);
    }

}
