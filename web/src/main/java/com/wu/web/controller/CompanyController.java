package com.wu.web.controller;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Company;
import com.wu.web.service.interfaces.CompanyService;
import com.wu.web.service.interfaces.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    public void sendItem (MainOrder mainOrder) {

    }


}
