package com.wu.web.dao;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Company;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
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

    Company queryByCompanyId(String companyId, HttpServletRequest request);

    List<Company> queryAllCompany();

//    Company updateCompanyInfo(Company company);

    Company updateCompanyName(String companyId, String newCompanyName);

    Company updateCompanyLocation(String companyId, String newLocation);

    Company updateCompanyStatus(String companyId, Integer newStatus);

    Company updateCompanyInfo(String companyId, String newCompanyInfo);

}
