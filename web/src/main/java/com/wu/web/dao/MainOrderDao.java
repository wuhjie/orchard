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
public interface MainOrderDao {

    MainOrder addOrder(MainOrder mainOrder);

    MainOrder queryByOrderId(String orderId);

    List<MainOrder> quertByCustomerId(String customerId);

    List<MainOrder> purchase(List<MainOrder> mainOrder);

    MainOrder orderFinished(MainOrder mainOrder);
}