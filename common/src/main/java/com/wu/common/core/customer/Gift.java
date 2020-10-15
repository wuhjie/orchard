package com.wu.common.core.customer;

import com.wu.common.core.garden.Tree;
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

public class Gift {

    public CustomerInfo sender;

    public CustomerInfo receiver;

    public Tree tree;

}
