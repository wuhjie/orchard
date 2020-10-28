package com.wu.web.service.interfaces;

import com.wu.common.domain.MainOrder;

import java.util.List;

/**
 * @ClassName OrderService
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 4:38 pm
 * @Version 1.0
 **/
public interface OrderService {

    boolean addOrder(MainOrder mainOrder);

    MainOrder queryById(String orderId);

    List<MainOrder> queryOrder();


}
