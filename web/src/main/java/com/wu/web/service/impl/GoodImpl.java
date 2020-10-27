package com.wu.web.service.impl;

import com.wu.common.domain.company.Good;
import com.wu.web.dao.GoodDao;
import com.wu.web.service.interfaces.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GoodImpl
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 3:11 pm
 * @Version 1.0
 **/

@Service
public class GoodImpl implements GoodService {

    private GoodDao goodDao;

    @Autowired
    public void setGoodDao(GoodDao goodDao) {
        this.goodDao = goodDao;
    }

    @Override
    public boolean addGood(Good good) {
        setGoodDao(goodDao);
        return goodDao.addGood(good);

    }

    @Override
    public Good queryById(String goodId) {
        setGoodDao(goodDao);
        return goodDao.queryById(goodId);
    }

    @Override
    public List<Good> queryAll() {
        setGoodDao(goodDao);
        return goodDao.queryAll();
    }
}
