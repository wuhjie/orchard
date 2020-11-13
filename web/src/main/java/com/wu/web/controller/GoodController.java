package com.wu.web.controller;

import com.wu.common.domain.ApiResponse;
import com.wu.common.domain.company.Good;
import com.wu.web.service.interfaces.GoodService;
import com.wu.web.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName GoodController
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 3:06 pm
 * @Version 1.0
 **/

@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    GoodService goodService;
    
    @Autowired
    OrderService orderService;

    @RequestMapping("/add")
    public ApiResponse<Good> addGood(Good good) {
        Good addedGood = goodService.addGood(good);
        return ApiResponse.ok(addedGood);
    }

    @GetMapping("/queryById/{goodId}")
    public ApiResponse<Good> queryById(@PathVariable("goodId") String goodId) {
        Good good = goodService.queryById(goodId);
        if (good == null) {
            throw new RuntimeException("fail");
        }
        return ApiResponse.ok(good);
    }

    @GetMapping("/list")
    public ApiResponse<List<Good>> queryAll() {
        List<Good> goodCollection = goodService.queryAll();
        return ApiResponse.ok(goodCollection);
    }
}
