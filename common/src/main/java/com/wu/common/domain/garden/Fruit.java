package com.wu.common.domain.garden;


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
@NoArgsConstructor
//@AllArgsConstructor
@Setter
@Getter
@ApiModel(value = "fruit info")
public class Fruit {

    @ApiModelProperty(value = "fruit species", name = "species")
    public String species;

//    @ApiModelProperty(value = "year of fruit", name = "fruitYear")
//    public Integer fruitYear;

    @ApiModelProperty(value = "units of fruit", name = "fruitUnit")
    public String fruitUnit = "kg";

    @ApiModelProperty(value = "price per piece", name = "fruitPrice")
    public BigDecimal fruitPrice;

    @ApiModelProperty(value = "if fruit is mature (0: no, 1: yes)", name = "matureStatus")
    public Integer matureStatus;

    public Fruit(String species, String fruitUnit, BigDecimal fruitPrice, Integer matureStatus) {
        this.species = species;
        this.fruitUnit = fruitUnit;
        this.fruitPrice = fruitPrice;
        this.matureStatus = matureStatus;
    }
}
