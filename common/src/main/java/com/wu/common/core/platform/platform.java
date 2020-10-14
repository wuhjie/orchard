package com.wu.common.core.platform;

import com.wu.common.core.customer.Customer;
import com.wu.common.core.garden.Company;
import com.wu.common.core.garden.Fruit;
import com.wu.common.core.garden.Tree;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("platform info")
public class platform {

    @ApiModelProperty(value = "companies on platform", name = "companies")
    public List<Company> companies;

    @ApiModelProperty(value = "all trees of all companies", name = "trees")
    public List<Tree> trees;

    @ApiModelProperty(value = "all fruits on platform", name = "fruits")
    public List<Fruit> fruits;

    @ApiModelProperty(value = "all customers on platform", name = "customers")
    public List<Customer> customers;


}
