package com.wu.common.core.service;


import com.wu.common.core.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author nullacc
 */

public interface OrderService {

    /**
     *
     * @return required list
     */
    List<Order>  getListForCurrentType();

    void exceptionHandler();
}
