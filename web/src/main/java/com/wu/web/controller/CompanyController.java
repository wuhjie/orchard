package com.wu.web.controller;

import com.wu.common.domain.company.Company;
import com.wu.web.service.interfaces.CompanyService;
import com.wu.web.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ConpanyController
 * @Description
 * @Author wuhjie
 * @Data 2020/10/27 11:06 am
 * @Version 1.0
 **/

@Controller
public class CompanyController {

    CompanyService companyService;

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("/company/add")
    public boolean addCompany(Company company) {
        return companyService.addCompany(company);
    }

    @GetMapping("company/queryById/{companyId}")
    public Company queryById(@PathVariable("companyId") String companyId) {
        Company company = companyService.queryById(companyId);

        if (company == null) {
            throw new RuntimeException("fail");
        }
        return company;
    }

    @RequestMapping("/company")
    public String queryAll() {
        return "redirect:/list.html";
    }
}
