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
import java.util.UUID;


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
}
