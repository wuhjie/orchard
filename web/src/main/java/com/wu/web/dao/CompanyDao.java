package com.wu.web.dao;

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

    Company addCompany (Company company);

    boolean addCompanyDetail (Company.CompanyDetails companyDetails);

    Company queryByCompanyId(String companyId);

    List<Company> queryAllCompany();

    Company updateCompanyInfo(String companyId);


}
