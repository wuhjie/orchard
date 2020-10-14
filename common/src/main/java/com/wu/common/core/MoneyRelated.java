package com.wu.common.core;

import com.wu.common.core.customer.Customer;
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
@ApiModel(value = "money related actions")
public class MoneyRelated {

    @ApiModelProperty(value = "operation on customer", name = "customer")
    public Customer customer;

    @ApiModelProperty(value = "withdraw amount", name = "withdrawAmount")
    public BigDecimal withdrawAmount;

    @ApiModelProperty(value = "frozen amount", name = "frozenAmount")
    public BigDecimal frozenAmount;

}
