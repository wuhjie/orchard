package com.wu.web.service.impl;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.customer.Customer;
import com.wu.web.dao.MainOrderDao;
import com.wu.web.service.interfaces.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName OrderImpl
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 4:42 pm
 * @Version 1.0
 **/
public class OrderImpl implements OrderService {

    private MainOrderDao mainOrderDao;

    @Autowired
    public void setMainOrderDao(MainOrderDao mainOrderDao) {
        this.mainOrderDao = mainOrderDao;
    }

    @Override
    public boolean addOrder(MainOrder mainOrder) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.addOrder(mainOrder);
    }

    @Override
    public MainOrder queryByOrderId(String orderId) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.queryByOrderId(orderId);
    }

    @Override
    public List<MainOrder> queryByCustomerId(Customer customer) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.quertByCustomerId(customer.getCustomerId());
    }

    @Override
    public MainOrder makingOrder(MainOrder mainOrder) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.makingOrder(mainOrder);
    }

    @Override
    public MainOrder orderFinished(MainOrder mainOrder) {
        setMainOrderDao(mainOrderDao);
        return mainOrderDao.orderFinished(mainOrder);
    }
}
