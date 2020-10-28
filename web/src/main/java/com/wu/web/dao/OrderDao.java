package com.wu.web.dao;

import com.wu.common.domain.MainOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName OrderDao
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 4:49 pm
 * @Version 1.0
 **/

@Mapper
@Repository
public interface OrderDao {
    /**
     *
     * @param mainOrder
     * @return
     */
    boolean addOrder(MainOrder mainOrder);

    /**
     *
     * @param orderId
     * @return
     */
    MainOrder queryByOrderId(String orderId);

    /**
     *
     * @param customerId
     * @return
     */
    List<MainOrder> quertByCustomerId(String customerId);

    /**
     *
     * @param mainOrder
     * @return
     */
    MainOrder orderStatusChanged(MainOrder mainOrder);

}
