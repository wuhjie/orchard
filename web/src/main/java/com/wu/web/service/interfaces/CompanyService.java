package com.wu.web.service.interfaces;

import com.wu.common.domain.company.Company;
import com.wu.common.domain.customer.Customer;

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

    boolean addCompany(Company compnay, HttpServletRequest request);

    Company queryByCompanyId(String companyId, HttpServletRequest request);

    List<Company> queryAllCompany();

//    Company updateCompanyInfo (Company company);

    Company updateCompanyName(Company company, String newCompanyName);

    Company updateCompanyLocation(Company company, String newLocation);

    Company updateCompanyStatus(Company company, Integer newStatus);

    Company updateCompanyInfo(Company company, String newInfo);
}
