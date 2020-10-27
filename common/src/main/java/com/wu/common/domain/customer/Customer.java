package com.wu.common.domain.customer;

//import com.wu.common.domain.garden.Garden;
//import com.wu.common.basic.Order;
//import com.wu.common.domain.garden.Tree;
//import com.wu.common.basic.platform.Wallet;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;



/**
 * @author wuhjie
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)


@Table(name = "Customer")

public class Customer implements Serializable {

    private String customerId;

    private String nickname;

    private Integer grade;

    private String tel;

    private String location;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdTime;

    private Integer gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

}
