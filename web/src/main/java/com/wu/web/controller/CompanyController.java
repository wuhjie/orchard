package com.wu.web.controller;

import com.wu.common.domain.ApiResponse;
import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Company;
import com.wu.web.dao.CompanyDao;
import com.wu.web.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName ConpanyController
 * @Description
 * @Author wuhjie
 * @Data 2020/10/27 11:06 am
 * @Version 1.0
 **/

@RestController

public class CompanyController {

    CompanyDao companyDao;

    @Autowired
    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public ApiResponse<Company> addCompany(Company company, Company.CompanyDetails companyDetails) {
        // add both details for a company
        Company returnCompanyDao =  companyDao.addCompany(company);
        companyDao.addCompanyDetail(companyDetails);

        return ApiResponse.ok(returnCompanyDao);
    }
    public ApiResponse<Company> queryCompanyById(@PathVariable("companyId") String companyId) {
        Company newCompany = companyDao.queryByCompanyId(companyId);

        return ApiResponse.ok(newCompany);
    }

    @RequestMapping("/company")
    public ApiResponse<List<Company>> queryAllCompany(@RequestParam List<Company> companyList) {
        companyList = companyDao.queryAllCompany();
        return ApiResponse.ok(companyList);
    }

    //todo check if correct
    public ApiResponse<Company> updateCompanyInfo (String companyId) {
        Company updatedCompany = companyDao.updateCompanyInfo(companyId);
        return ApiResponse.ok(updatedCompany);
    }


}
