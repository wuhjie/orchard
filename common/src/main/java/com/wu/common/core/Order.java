package com.wu.common.core;

import com.wu.common.core.customer.CustomerInfo;
import com.wu.common.core.garden.Garden;
import com.wu.common.core.garden.Tree;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nullacc
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "order")
public class Order {

    /**
     * todo orderTime type
     */
    @ApiModelProperty(value = "order time", name = "orderTime")
    public String orderTime;

    @ApiModelProperty(value = "order related company", name = "company")
    public Garden company;

    @ApiModelProperty(value = "order related customerInfo", name = "customerInfo")
    public CustomerInfo customerInfo;

    @ApiModelProperty(value = "order related tree", name = "orderedTree")
    public Tree orderedTree;

    @ApiModelProperty(value = "order id", name = "orderId")
    public String orderId;

    @ApiModelProperty(value = "order status (0: pending, 1: finished, 2: cancelled)", name = "orderStatus")
    public Integer orderStatus;


}
