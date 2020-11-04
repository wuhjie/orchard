package com.wu.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName MainOrder
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 4:30 pm
 * @Version 1.0
 **/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
public class MainOrder implements Serializable {

    @Column
    String customerId;

    @Id
    @GeneratedValue
    String mainOrderId;

    @Column
    BigDecimal mainOrderPrice;

    @Column
    Integer mainOrderStatus;

    @Column
    Integer amount;

    public MainOrder(String customerId, BigDecimal mainOrderPrice, Integer mainOrderStatus, Integer amount) {
        this.customerId = customerId;
        this.mainOrderPrice = mainOrderPrice;
        this.mainOrderStatus = mainOrderStatus;
        this.amount = amount;
        this.mainOrderId = UUID.randomUUID().toString();
    }

    /**
     * @ClassName MainOrder
     * @Description
     * @Author wuhjie
     * @Data 2020/10/29 4:23 pm
     * @Version 1.0
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    @Entity
    public static class subOrder implements Serializable {

        @Column(nullable = false, unique = true)
        String customerId;

        @Column
        String goodId;

        @Column(nullable = false, unique = true)
        BigDecimal goodPrice;

        @Column
        BigDecimal shippingPrice;

        @Column(nullable = false)
        Date createdTime;

        @Column
        Date finishedTime;

        @Column
        OrderStatus orderStatus;

        @Column
        String shippingAddress;

        @Column
        String goodName;

        @Column
        String companyId;

        @Column
        String companyName;

        @Column
        String deliveryAddress;

        @Column
        Integer amount;

        @Column
        String expressId;

        @Id
        @GeneratedValue
        String subOrderId;

        public subOrder(String customerId, String goodId, BigDecimal goodPrice, BigDecimal shippingPrice, Date createdTime, Date finishedTime, OrderStatus orderStatus, String shippingAddress, String goodName, String companyId, String companyName, String deliveryAddress, Integer amount, String expressId) {
            this.customerId = customerId;
            this.goodId = goodId;
            this.goodPrice = goodPrice;
            this.shippingPrice = shippingPrice;
            this.createdTime = createdTime;
            this.finishedTime = finishedTime;
            this.orderStatus = orderStatus;
            this.shippingAddress = shippingAddress;
            this.goodName = goodName;
            this.companyId = companyId;
            this.companyName = companyName;
            this.deliveryAddress = deliveryAddress;
            this.amount = amount;
            this.expressId = expressId;
            this.customerId = UUID.randomUUID().toString();
        }

        public static enum OrderStatus {

            /**
             * status for order
             */
            inShoppingCart(0, "still in the shopping cart"),
            itemSelected(8, "this item has been selected"),
            orderPending(1, "order processed, pending"),
            orderReceived(2, "order has been sent to the company"),
            expressReceived(3, "the order is sending to the express"),
            orderShipping(4, "the good is delivering"),
            orderShipped(5, "the good has been delivered"),
            orderFinished(6, "the order is finished, historic order"),
            orderCancelled(7, "this order is cancelled");

            OrderStatus(int code, String msg) {
            }

        }

    }


}