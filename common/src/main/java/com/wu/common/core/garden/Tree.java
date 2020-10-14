package com.wu.common.core.garden;

import com.wu.common.core.garden.Company;
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
@ApiModel(value = "treeProperty")
public class Tree {

    @ApiModelProperty(value = "tree id", name = "treeId")
    private String treeId;

    @ApiModelProperty(value = "annual output", name = "annualOutput")
    private Integer annualOutput;

    @ApiModelProperty(value = "company belonged", name = "originCompany")
    private Company originCompany;

    @ApiModelProperty(value = "origin location", name = "location")
    private String location;

    @ApiModelProperty(value = "treeSpecies", name = "species")
    private String species;

    @ApiModelProperty(value = "treeYear", name = "treeYear")
    private Integer treeYear;

    @ApiModelProperty(value = "subscribed status (yes:1, no:0)", name = "subscribedStatus")
    private Integer subscribedStatus;

    @ApiModelProperty(value = "time when mature", name = "matureTime")
    private String matureTime;

    @ApiModelProperty(value = "end time for subscribe", name = "subscribeEndingTime")
    private String subscribeEndingTime;

    @ApiModelProperty(value = "amount of trees left", name = "treeLeftAmount")
    private Integer treeLeftAmount;

    @ApiModelProperty(value = "fruit of this tree", name = "fruit")
    private Fruit fruit;
}
