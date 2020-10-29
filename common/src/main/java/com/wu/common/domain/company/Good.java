package com.wu.common.domain.company;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

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

    public String goodId;

    public String goodName;

    public Date createdTime;

    public BigDecimal price;

    public String companyId;

    public Integer amount;
}
