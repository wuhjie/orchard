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
public interface MainOrderDao {

    MainOrder addOrder(MainOrder mainOrder);

    MainOrder queryByOrderId(String orderId);

    List<MainOrder> quertAll(String customerId);

    List<MainOrder> purchase(List<MainOrder> mainOrder);

    List<MainOrder> subOrderIntoMainOrder(List<MainOrder> mainOrder);

    MainOrder inShoppingCart(Good good);

    MainOrder orderPending(UUID subOrderId);

    MainOrder orderReceived(UUID subOrderId);

    MainOrder expressReceived(UUID subOrderId);

    MainOrder orderShipping(UUID subOrderId);

    MainOrder orderShipped(UUID subOrderId);

    MainOrder orderFinished(UUID subOrderId);

    MainOrder orderCancelled(UUID subOrderId);

    void removeFromShoppingCart(UUID subOrderId);
}
