package com.wu.web.dao;

import com.wu.common.domain.company.Good;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName GoodDao
 * @Description
 * @Author wuhjie
 * @Data 2020/10/26 3:14 pm
 * @Version 1.0
 **/

@Mapper
@Repository
public interface GoodDao {

    Good addGood(Good good);

    Good queryById (String goodId);

    List<Good> queryAll();
}
