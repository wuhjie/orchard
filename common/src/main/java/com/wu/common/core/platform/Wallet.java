package com.wu.common.core.platform;

import com.wu.common.core.Record;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author nullacc
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "walletOfCustomer")
public class Wallet {

    @ApiModelProperty(value = "remain on Account", name = "remain")
    public BigDecimal remain;

    @ApiModelProperty(value = "money that could withdraw", name = "withdrawAmount")
    public BigDecimal withdrawAmount;

    @ApiModelProperty(value = "amount of money that been frozen", name = "frozenAmount")
    public BigDecimal frozenAmount;

    @ApiModelProperty(value = "order record of this account", name = "records")
    public List<Record> records;

    @ApiModelProperty(value = "credits on account", name = "customerCredits")
    public BigDecimal customerCredits;
}
