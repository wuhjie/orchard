package com.wu.web.controller;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Company;
import com.wu.web.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ConpanyController
 * @Description
 * @Author wuhjie
 * @Data 2020/10/27 11:06 am
 * @Version 1.0
 **/

@RestController

public class CompanyController {

    CompanyService companyService;

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("/company/add")
    public boolean addCompany(Company company, HttpServletRequest request) {

        return companyService.addCompany(company, request);
    }

    @GetMapping("company/queryByCompanyId/{companyId}")
    public Company queryByCompanyId(@PathVariable("companyId") String companyId, HttpServletRequest request) {
        Company company = companyService.queryByCompanyId(companyId, request);

        if (company == null) {
            throw new RuntimeException("fail");
        }
        return company;
    }

    @RequestMapping("/company")
    public String queryAllCompany() {
        return "redirect:/list.html";
    }

    /**
     * todo
     * submitted verification form
     */
    public void submittedVerificationForm (Company company){

    }

    /**
     * for changing status of order
     * @param mainOrder
     */
    public void sendItem (MainOrder mainOrder) {

    }


}
