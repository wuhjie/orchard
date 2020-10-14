package com.wu.common.core.garden;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nullacc
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ApiModel(value = "fruit info")
public class Fruit {

    @ApiModelProperty(value = "fruit species", name = "species")
    public String species;

    @ApiModelProperty(value = "year of fruit", name = "fruitYear")
    public Integer fruitYear;

    @ApiModelProperty(value = "units of fruit", name = "fruitUnit")
    public String fruitUnit = "kg";

}
