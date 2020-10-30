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
public interface MainOrderDao {

    MainOrder addOrder(MainOrder mainOrder);

    MainOrder queryByOrderId(String orderId);

    List<MainOrder> quertAll(String customerId);

    List<MainOrder> purchase(List<MainOrder> mainOrder);

    List<MainOrder> subOrderIntoMainOrder(List<MainOrder> mainOrder);

    MainOrder orderFinished(String orderId);

    MainOrder orderReceived(String orderId);

    MainOrder addToShoppingCart(Good good);
}
