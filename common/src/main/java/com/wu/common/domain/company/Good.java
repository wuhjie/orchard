package com.wu.common.domain.company;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author wuhjie
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Good {

    @Id
    @GeneratedValue
    public String goodId;

    @Column
    public String goodName;

    @Column
    public Date createdTime;

    @Column
    public BigDecimal price;

    @Column
    public String companyId;

    @Column
    public Integer amount;

    @Column
    public Date pickTime;

    public static enum goodStatus {

        /**
         * status for fruit / tree
         */
        immature(0, "the tree / fruit is still immature"),
        readyToPick(1, "the tree / fruit is ready to be picked");

        goodStatus(int code, String msg) {
        }
    }
}
