package com.wu.common.domain.customer;

import com.wu.common.domain.garden.Fruit;
import com.wu.common.domain.garden.Tree;
import io.swagger.annotations.ApiModel;

import java.util.Date;
import java.util.List;

/**
 * @author nullacc
 */
public class ShoppingCart {

    public String customerId;

    public String goodId;

    public String goodName;

    public Date createdTime;

}
