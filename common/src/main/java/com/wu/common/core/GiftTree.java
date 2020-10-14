package com.wu.common.core;

import com.wu.common.core.customer.Customer;
import com.wu.common.core.garden.Tree;
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
    public Customer sender;

    @ApiModelProperty(value = "who receives the tree", name = "receiver")
    public Customer receiver;


    public void giftingTree(String treeId, Customer sender, Customer receiver) {
        try {
            List<Tree> senderTreeList = sender.getOwnedTrees();
//            senderTreeList.contains(treeId)
        }catch (Exception e) {
            //todo
            System.out.println("current Tree not found");
        }


    }
}
