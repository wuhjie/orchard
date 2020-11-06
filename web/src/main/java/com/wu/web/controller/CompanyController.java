package com.wu.web.controller;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Company;
import com.wu.web.dao.CompanyDao;
import com.wu.web.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public String addCompany(Company company, Company.CompanyDetails companyDetails) {
        // add both details for a company
        companyDao.addCompany(company);
        companyDao.addCompanyDetail(companyDetails);
        return String.format("company/companyPortal%s", company.getCompanyId());
    }

    public String queryCompanyById(@PathVariable("companyId") String companyId, Model model) {
        Company company = companyDao.queryByCompanyId(companyId);
        model.addAttribute("queryCompanyById", company);
        return "redirect:/company/list";
    }

    public String queryAllCompany(Model model) {
        List<Company> companyList = companyDao.queryAllCompany();
        model.addAttribute("queryAllCompany", companyList);
        return "company/list";
    }

    public String updateCompanyInfo (Model model, String companyId) {
        Company updatedCompany = companyDao.updateCompanyInfo(companyId);
        model.addAttribute("updateCompanyInfo", updatedCompany);
        return "redirect:/company/companyPortal";
    }


}
