package com.wu.core.service;


import com.wu.common.basic.Order;

import java.util.List;

/**
 * @author nullacc
 */

public interface OrderService {


    List<Order>  getListForCurrentType();

    void exceptionHandler();
}
