package com.wu.common.basic;

import com.wu.common.domain.customer.CustomerInfo;
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

    @ApiModelProperty(value = "operation on customerInfo", name = "customerInfo")
    public CustomerInfo customerInfo;

    @ApiModelProperty(value = "withdraw amount", name = "withdrawAmount")
    public BigDecimal withdrawAmount;

    @ApiModelProperty(value = "frozen amount", name = "frozenAmount")
    public BigDecimal frozenAmount;

}
