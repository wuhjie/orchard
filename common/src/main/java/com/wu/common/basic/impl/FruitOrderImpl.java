package com.wu.common.basic.impl;


import com.wu.common.basic.Order;

import com.wu.core.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author nullacc
 */
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class FruitOrderImpl implements OrderService {


    @Override
    public List<Order> getListForCurrentType() {
        return null;
    }

    @Override
    public void exceptionHandler() {

    }
}
