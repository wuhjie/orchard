package com.wu.web.service.impl;

import com.wu.common.domain.company.Company;
import com.wu.web.dao.CompanyDao;
import com.wu.web.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName CompanyImpl
 * @Description
 * @Author wuhjie
 * @Data 2020/10/27 11:06 am
 * @Version 1.0
 **/

@Service
public class CompanyImpl implements CompanyService {

    private CompanyDao companyDao;

    @Autowired
    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public Company addCompany(Company company) {
        setCompanyDao(companyDao);
        return companyDao.addCompany(company);
    }

    @Override
    public Company queryByCompanyId(String companyId) {
        setCompanyDao(companyDao);
        return companyDao.queryByCompanyId(companyId);
    }

    @Override
    public List<Company> queryAllCompany() {
        setCompanyDao(companyDao);
        return companyDao.queryAllCompany();
    }
    @Override
    public Company updateCompanyInfo(Company company) {
        setCompanyDao(companyDao);
        String companyId = company.getCompanyId();
        return companyDao.updateCompanyInfo(companyId);
    }
}
