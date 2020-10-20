package com.wu.common.basic;

import com.wu.common.domain.customer.CustomerInfo;
import com.wu.common.domain.garden.Tree;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author nullacc
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel(value = "gift tree")
public class GiftTree {

    @ApiModelProperty(value = "id of tree")
    public String treeId;

    @ApiModelProperty(value = "who sends the tree", name = "sender")
    public CustomerInfo sender;

    @ApiModelProperty(value = "who receives the tree", name = "receiver")
    public CustomerInfo receiver;


    public void giftingTree(String treeId, CustomerInfo sender, CustomerInfo receiver) {
        try {
            List<Tree> senderTreeList = sender.getOwnedTrees();
//            senderTreeList.contains(treeId)
        }catch (Exception e) {
            //todo
            System.out.println("current Tree not found");
        }


    }
}
