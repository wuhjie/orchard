package com.wu.common.core;

import com.wu.common.core.customer.Customer;
import com.wu.common.core.garden.Company;
import com.wu.common.core.garden.Tree;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author nullacc
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "orderRecord")
public class Record extends Order{

    @ApiModelProperty(value = "price of order", name = "order")
    public BigDecimal price;

    @ApiModelProperty(value = "remain amount on account", name = "remain")
    public BigDecimal remain;

    @ApiModelProperty(value = "order time", name = "orderTime")
    public String orderTime;

    @ApiModelProperty(value = "order related company", name = "company")
    public Company company;

    @ApiModelProperty(value = "order related customer", name = "customer")
    public Customer customer;

    @ApiModelProperty(value = "order related tree", name = "orderedTree")
    public Tree orderedTree;


}
