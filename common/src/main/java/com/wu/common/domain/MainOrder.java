package com.wu.common.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName MainOrder
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 4:30 pm
 * @Version 1.0
 **/
public class MainOrder {

    String customerId;

    String mainOrderId;

    BigDecimal mainOrderPrice;

    Integer mainOrderStatus;

    private static class subOrder {

        String customerId;

        String orderId;

        String goodName;

        BigDecimal orderPrice;

        Date createdTime;

        Date finishedTime;

        Integer orderStatus;

        String shippingAddress;

        String deliveryAddress;

        String companyId;

        String companyName;

    }

    private enum OrderStatus{

        /**
         * status for order
         */
        InShoppingCart(0, "still in the shopping cart"),
        orderPending(1, "order processed, pending"),
        orderSuccess(2, "order has been sent to the company"),
        itemSentOut(3, "the order is sending to the express"),
        orderShipping(4, "the good is delivering"),
        orderShipped(5, "the good has been delivered"),
        orderFinished(6, "the order is finished, historic order"),
        orderCancelled(7, "this order is cancelled");

        OrderStatus(int code, String msg) {
        }


    }


}