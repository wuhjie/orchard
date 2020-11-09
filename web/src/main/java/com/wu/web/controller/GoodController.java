package com.wu.web.controller;

import com.wu.common.domain.ApiResponse;
import com.wu.common.domain.company.Good;
import com.wu.web.dao.GoodDao;
import com.wu.web.dao.OrderDao;
import com.wu.web.service.interfaces.GoodService;
import com.wu.web.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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


    GoodDao goodDao;
    OrderDao orderDao;

    @Autowired
    public void setGoodDao (GoodDao goodDao) {
        this.goodDao = goodDao;
    }

    @Autowired
    public void setOrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @RequestMapping("/good/add")
    public ApiResponse<Good> addGood(Good good) {
        Good addedGood = goodDao.addGood(good);
        return ApiResponse.ok(addedGood);
    }

    @GetMapping("good/queryById/{goodId}")
    public ApiResponse<Good> queryById(@PathVariable("goodId") String goodId) {
        Good good = goodDao.queryById(goodId);
        if (good == null) {
            throw new RuntimeException("fail");
        }
        return ApiResponse.ok(good);
    }

    @GetMapping("/good")
    public ApiResponse<List<Good>> queryAll() {
        List<Good> goodCollection = goodDao.queryAll();
        return ApiResponse.ok(goodCollection);
    }



}
