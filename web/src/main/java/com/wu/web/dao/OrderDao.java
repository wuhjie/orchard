package com.wu.web.dao;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Good;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName OrderDao
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 4:49 pm
 * @Version 1.0
 **/

@Mapper
@Repository
public interface OrderDao {

    MainOrder.SubOrder addOrder (MainOrder.SubOrder subOrder);

    MainOrder.SubOrder queryByOrderId (String orderId);

    MainOrder.SubOrder queryWithItemId (String goodId);

    List<MainOrder.SubOrder> queryAllWithCustomerId (String customerId);

    List<MainOrder.SubOrder> queryAll ();

    MainOrder.SubOrder inShoppingCart (Good good);

    List<MainOrder.SubOrder> itemSelected (List<MainOrder.SubOrder> subOrder);

    MainOrder.SubOrder purchase (MainOrder.SubOrder subOrders);

    MainOrder subOrderIntoMainOrder (List<MainOrder.SubOrder> subOrder);

    MainOrder.SubOrder orderPending (String subOrderId);

    MainOrder.SubOrder orderReceived (String subOrderId);

    MainOrder.SubOrder expressReceived (String subOrderId);

    MainOrder.SubOrder orderShipping (String subOrderId);

    MainOrder.SubOrder orderShipped (String subOrderId);

    MainOrder.SubOrder orderFinished (String subOrderId);

    MainOrder.SubOrder orderCancelled (String subOrderId);

    void removeFromShoppingCart (String subOrderId, String customerId);

    MainOrder.GiftingItem giftPending (MainOrder.SubOrder subOrder);

    void itemIntoPresentGiving (MainOrder.GiftingItem giftingItem);



}
