package com.wu.common.basic.platform;

import com.wu.common.domain.customer.Customer;
import com.wu.common.domain.garden.Garden;
import com.wu.common.domain.garden.Fruit;
import com.wu.common.domain.garden.Tree;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author nullacc
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ApiModel("platform info")
public class Platform {

//    @ApiModelProperty(value = "companies on platform", name = "companies")
    public List<Garden> companies;

//    @ApiModelProperty(value = "all trees of all companies", name = "trees")
    public List<Tree> trees;

//    @ApiModelProperty(value = "all fruits on platform", name = "fruits")
    public List<Fruit> fruits;

//    @ApiModelProperty(value = "all customerInfos on platform", name = "customerInfos")
    public List<Customer> customers;

    public String tel;

}
