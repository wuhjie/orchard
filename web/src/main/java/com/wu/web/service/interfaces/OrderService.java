package com.wu.web.service.interfaces;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Good;
import com.wu.common.domain.customer.Customer;
import com.wu.web.dao.MainOrderDao;

import java.util.List;

/**
 * @ClassName OrderService
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 4:38 pm
 * @Version 1.0
 **/
public interface OrderService {

    MainOrder addOrder(MainOrder mainOrder);

    MainOrder queryByOrderId(String orderId);

    List<MainOrder> queryByCustomerId(Customer customer);

    List<MainOrder> purchase(List<MainOrder> orders);

    List<MainOrder> subOrderIntoMainOrder(List<MainOrder> orders);

    MainOrder orderFinished(MainOrder mainOrder);

//    MainOrder statusChanged(String orderId, MainOrder.subOrder.OrderStatus changedStatus);

    MainOrder orderReceived(String orderId);

    MainOrder addToShoppingCart(Good good);
}
