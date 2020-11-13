package com.wu.web.controller;

import com.wu.common.domain.ApiResponse;
import com.wu.common.domain.company.Company;
import com.wu.web.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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

    @Autowired
    CompanyService companyService;


    public ApiResponse<Company> addCompany(Company company, Company.CompanyDetails companyDetails) {
        // add both details for a company
        Company returncompanyService =  companyService.addCompany(company);
        companyService.addCompanyDetails(companyDetails);

        return ApiResponse.ok(returncompanyService);
    }
    public ApiResponse<Company> queryCompanyById(@PathVariable("companyId") String companyId) {
        Company newCompany = companyService.queryByCompanyId(companyId);

        return ApiResponse.ok(newCompany);
    }

    @RequestMapping("/list")
    public ApiResponse<List<Company>> queryAllCompany() {
        List<Company> companyList = companyService.queryAllCompany();
        return ApiResponse.ok(companyList);
    }

    //todo check if correct
    public ApiResponse<Company> updateCompanyInfo (String companyId) {
        Company updatedCompany = companyService.updateCompanyInfo(companyService.queryByCompanyId(companyId));
        return ApiResponse.ok(updatedCompany);
    }


}
