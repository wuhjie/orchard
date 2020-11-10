package com.wu.web.service.interfaces;

import com.wu.common.domain.company.Good;

import java.util.List;

/**
 * @ClassName GoodService
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 3:10 pm
 * @Version 1.0
 **/
public interface GoodService {

    Good addGood(Good good);

    Good queryById (String goodId);

    List<Good> queryAll();
}
