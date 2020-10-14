package com.wu.common.core.garden;

import com.wu.common.core.Order;
import com.wu.common.core.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author nullacc
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "platform for company")
public class Company {

    @ApiModelProperty(value = "order list", name = "companyOrders")
    List<Order> companyOrders;

    @ApiModelProperty(value = "trees of company", name = "ownedTrees")
    List<Tree> ownedTrees;

    @ApiModelProperty(value = "fruits of company", name = "ownedFruits")
    List<Fruit> ownedFruits;

    @ApiModelProperty(value = "followers", name = "followers")
    List<Customer> followers;

    @ApiModelProperty(value = "level based on transaction amount", name = "level")
    public Integer level;

}
