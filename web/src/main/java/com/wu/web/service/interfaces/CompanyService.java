package com.wu.web.service.interfaces;

import com.wu.common.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName CompanyService
 * @Description
 * @Author wuhjie
 * @Data 2020/10/27 11:06 am
 * @Version 1.0
 **/


public interface CompanyService {

    Company addCompany(Company compnay);

    Company.CompanyDetails addCompanyDetails(Company.CompanyDetails companyDetails);

    Company queryByCompanyId(String companyId);

    List<Company> queryAllCompany();

    Company updateCompanyInfo(Company company);
}
