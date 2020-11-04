package com.wu.web.dao;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Good;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

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

    MainOrder.subOrder addOrder(MainOrder.subOrder subOrder);

    MainOrder.subOrder queryByOrderId(String orderId);

    List<MainOrder.subOrder> quertAll(String customerId);

    MainOrder.subOrder inShoppingCart(Good good);

    List<MainOrder.subOrder> itemSelected(List<MainOrder.subOrder> subOrder);

    MainOrder.subOrder purchase(MainOrder.subOrder subOrders);

    List<MainOrder> subOrderIntoMainOrder(List<MainOrder.subOrder> subOrder);

    MainOrder.subOrder orderPending(String subOrderId);

    MainOrder.subOrder orderReceived(String subOrderId);

    MainOrder.subOrder expressReceived(String subOrderId);

    MainOrder.subOrder orderShipping(String subOrderId);

    MainOrder.subOrder orderShipped(String subOrderId);

    MainOrder.subOrder orderFinished(String subOrderId);

    MainOrder.subOrder orderCancelled(String subOrderId);

    void removeFromShoppingCart(String subOrderId);
}
