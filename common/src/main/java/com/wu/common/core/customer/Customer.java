package com.wu.common.core.customer;

import com.wu.common.core.garden.Company;
import com.wu.common.core.Order;
import com.wu.common.core.garden.Tree;
import com.wu.common.core.platform.Wallet;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "customer")
public class Customer {

    @ApiModelProperty(value = "nickname on the platform", name = "nickname")
    private String nickname;

    @ApiModelProperty(value = "company that customer follows", name = "followingCompanies")
    private List<Company> followingCompanies;

    @ApiModelProperty(value = "trees that customer follows", name = "followingTrees")
    private List<Tree> followingTrees;

    @ApiModelProperty(value = "customer order history", name = "orderHistory")
    private List<Order> orderHistory;

    @ApiModelProperty(value = "trees as gift", name = "sentTrees")
    private List<Tree> sentTrees;

    @ApiModelProperty(value = "list of trees", name = "ownedTrees")
    private List<Tree> ownedTrees;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Company> getFollowingCompanies() {
        return followingCompanies;
    }

    public void setFollowingCompanies(List<Company> followingCompanies) {
        this.followingCompanies = followingCompanies;
    }

    public List<Tree> getFollowingTrees() {
        return followingTrees;
    }

    public void setFollowingTrees(List<Tree> followingTrees) {
        this.followingTrees = followingTrees;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public List<Tree> getSentTrees() {
        return sentTrees;
    }

    public void setSentTrees(List<Tree> sentTrees) {
        this.sentTrees = sentTrees;
    }

    public List<Tree> getOwnedTrees() {
        return ownedTrees;
    }

    public void setOwnedTrees(List<Tree> ownedTrees) {
        this.ownedTrees = ownedTrees;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel(value = "personal info for customer")
    public static class CustomerInfo {

        @ApiModelProperty(value = "real name", name = "name")
        private String name;

        @ApiModelProperty(value = "wechat Id", name = "wechatId")
        private String wechatId;

        @ApiModelProperty(value = "personal wallet", name = "personalWallet")
        private Wallet personalWallet;

        @ApiModelProperty(value = "order history of customer", name = "orderHistory")
        private List<Order> orderHistory;


    }


}
