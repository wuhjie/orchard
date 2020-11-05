package com.wu.web.controller;

import com.wu.common.domain.company.Good;
import com.wu.web.service.interfaces.GoodService;
import com.wu.web.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName GoodController
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 3:06 pm
 * @Version 1.0
 **/

@RestController
public class GoodController {

    GoodService goodService;
    OrderService orderService;

    @Autowired
    public void setGoodService (GoodService goodService) {
        this.goodService = goodService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/good/add")
    public boolean addGood(Good good) {
        return goodService.addGood(good);
    }

    @GetMapping("good/queryById/{goodId}")
    public Good queryById(@PathVariable("goodId") String goodId) {
        Good good = goodService.queryById(goodId);
        if (good == null) {
            throw new RuntimeException("fail");
        }
        return good;
    }

    @GetMapping("/good")
    public List<Good> queryAll() {
        return goodService.queryAll();
    }

}
