package com.wu.common.domain.customer;

//import com.wu.common.domain.garden.Garden;
//import com.wu.common.basic.MainOrder;
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

import javax.persistence.*;
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
@Entity

public class Customer implements Serializable {

    @Id
    @GeneratedValue
    private String customerId;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private Integer grade;

    @Column
    private String tel;

    @Column
    private String location;

    @Column
    private Integer status;

    @Column
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date createdTime;

    @Column(nullable = false)
    private Integer gender;

    @Column
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthday;

}
