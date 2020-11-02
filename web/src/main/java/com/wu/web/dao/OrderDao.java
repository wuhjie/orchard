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

    MainOrder.subOrder queryByOrderId(UUID orderId);

    List<MainOrder.subOrder> quertAll(UUID customerId);

    MainOrder.subOrder inShoppingCart(Good good);

    List<MainOrder.subOrder> itemSelected(List<MainOrder.subOrder> subOrder);

    MainOrder.subOrder purchase(MainOrder.subOrder subOrders);

    List<MainOrder> subOrderIntoMainOrder(List<MainOrder.subOrder> subOrder);

    MainOrder.subOrder orderPending(UUID subOrderId);

    MainOrder.subOrder orderReceived(UUID subOrderId);

    MainOrder.subOrder expressReceived(UUID subOrderId);

    MainOrder.subOrder orderShipping(UUID subOrderId);

    MainOrder.subOrder orderShipped(UUID subOrderId);

    MainOrder.subOrder orderFinished(UUID subOrderId);

    MainOrder.subOrder orderCancelled(UUID subOrderId);

    void removeFromShoppingCart(UUID subOrderId);
}
