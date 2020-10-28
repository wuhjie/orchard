package com.wu.web.controller;

import com.wu.common.domain.MainOrder;
import com.wu.web.dao.MainOrderDao;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @ClassName MainOrderController
 * @Description
 * @Author wuhjie
 * @Data 2020/10/28 3:18 pm
 * @Version 1.0
 **/

@RestController
public class MainOrderController {

    MainOrderDao mainOrderDao;

    @Autowired
    public void setMainOrderDao(MainOrderDao mainOrderDao) {
        this.mainOrderDao = mainOrderDao;
    }

    @RequestMapping("/mainOrder/add")
    public String addOrder(MainOrder mainOrder) {
        mainOrderDao.addOrder(mainOrder);
        return "redirect:/mainOrder";
    }

    @GetMapping("mainOrder/queryById/{orderId}")
    public String queryByOrderId(@PathVariable("orderId") String orderId) {
        MainOrder mainOrder = mainOrderDao.queryByOrderId(orderId);
        if (mainOrder == null) {
            return "404";
        }
        //todo
        return "mainOrder/update";
    }

    @GetMapping("mainOrder/queryByCustomerId/{customerId}")
    public String queryByCustomerId(@PathVariable("customerId") String customerId) {
        Collection<MainOrder> mainOrderCollection = mainOrderDao.quertByCustomerId(customerId);
        //todo
        return "mainOrder/list";
    }



}
