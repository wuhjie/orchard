package com.wu.common.domain.customer;

import com.wu.common.domain.garden.Garden;
import com.wu.common.basic.Order;
import com.wu.common.domain.garden.Tree;
import com.wu.common.basic.platform.Wallet;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "customerInfo")
public class CustomerInfo {

    @ApiModelProperty(value = "nickname on the platform", name = "nickname")
    private Integer customerId;

    @ApiModelProperty(value = "level of customerInfo", name = "customerLevel")
    private Integer customerLevel;

//    @ApiModelProperty(value = "company that customerInfo follows", name = "followingCompanies")
//    private List<Garden> followingCompanies;

    @ApiModelProperty(value = "trees that customerInfo follows", name = "followingTrees")
    private List<Tree> followingTrees;

    @ApiModelProperty(value = "customerInfo order history", name = "orderHistory")
    private List<Order> orderHistory;

    @ApiModelProperty(value = "trees as gift", name = "sentTrees")
    private List<Tree> sentTrees;

    @ApiModelProperty(value = "list of trees", name = "ownedTrees")
    private List<Tree> ownedTrees;

    public List<Tree> getOwnedTrees() {
        return ownedTrees;
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel(value = "personal info for customerInfo")
    public static class CustomerPersonalInfo {

        private String tel;

        private Wallet personalWallet;

        private List<Order> orderHistory;

        private Set<String> tokens;
    }
}
