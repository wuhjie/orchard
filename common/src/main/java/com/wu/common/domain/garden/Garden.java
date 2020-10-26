package com.wu.common.domain.garden;

import com.wu.common.basic.Order;
import com.wu.common.domain.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author nullacc
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "platform for company")
public class Garden {

    @ApiModelProperty(value = "order list", name = "companyOrders")
    List<Order> companyOrders;

    @ApiModelProperty(value = "trees of company", name = "ownedTrees")
    List<Tree> ownedTrees;

    //hashmao?
    @ApiModelProperty(value = "fruits of company", name = "ownedFruits")
    List<Fruit> ownedFruits;

    @ApiModelProperty(value = "followers", name = "followers")
    List<Customer> followers;

    @ApiModelProperty(value = "level based on transaction amount", name = "level")
    public Integer level;

    @ApiModelProperty(value = "company status (0: normal, 1: abnormal)", name = "companyStaus")
    public Integer companyStatus;

    @ApiModelProperty(value = "level of company", name = "companyLevel")
    public Integer companyLevel;

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    private static class FinancialStatus {

        public BigDecimal income;

        public BigDecimal insurance;
    }
}
