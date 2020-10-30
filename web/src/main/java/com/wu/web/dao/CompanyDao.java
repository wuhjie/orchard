package com.wu.web.dao;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Company;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName CompanyDao
 * @Description
 * @Author wuhjie
 * @Data 2020/10/23 9:35 am
 * @Version 1.0
 **/

@Mapper
@Repository
public interface CompanyDao {

    boolean addCompany (Company company);

    Company queryById(String companyId);

    List<Company> queryAll();

//    MainOrder orderReceived(String orderId);
}
