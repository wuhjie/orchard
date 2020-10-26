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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "tree")
public class Tree {

    @ApiModelProperty(value = "annual output", name = "annualOutput")
    private Integer annualOutput;

    @ApiModelProperty(value = "time when mature", name = "matureTime")
    private String matureTime;

    @ApiModelProperty(value = "if mature", name = "matureStatus")
    private Integer matureStatus;

    @ApiModelProperty(value = "end time for subscribe", name = "subscribeEndingTime")
    private String subscribeEndingTime;

    @ApiModelProperty(value = "amount of trees left", name = "treeLeftAmount")
    private Integer treeLeftAmount;

    @ApiModelProperty(value = "amount of fruit on this tree", name = "amountOfFruit")
    public Integer amountOfFruit;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel(value = "treeInfo")
    public static class TreeInfo {

        @ApiModelProperty(value = "tree id", name = "treeId")
        private String treeId;

        @ApiModelProperty(value = "company belonged", name = "originCompany")
        private Garden originCompany;

        @ApiModelProperty(value = "origin location", name = "location")
        private String location;

        @ApiModelProperty(value = "treeSpecies", name = "species")
        private String species;

        @ApiModelProperty(value = "treeYear", name = "treeYear")
        private Integer treeYear;

        @ApiModelProperty(value = "price per piece", name = "treePrice")
        public BigDecimal treePrice;

        @ApiModelProperty(value = "", name = "authorityYear")
        public Integer authorityYear;

        @ApiModelProperty(value = "if is subscribed")
        public Integer subscriptionStatus;
    }

}
