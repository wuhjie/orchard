package com.wu.web.service.impl;

import com.wu.common.domain.MainOrder;
import com.wu.web.service.interfaces.OrderService;

import java.util.List;

/**
 * @ClassName OrderImpl
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 4:42 pm
 * @Version 1.0
 **/
public class OrderImpl implements OrderService {



    @Override
    public boolean addOrder(MainOrder mainOrder) {
        return false;
    }

    @Override
    public MainOrder queryById(String orderId) {
        return null;
    }

    @Override
    public List<MainOrder> queryOrder() {
        return null;
    }
}
