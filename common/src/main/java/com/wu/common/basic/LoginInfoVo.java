package com.wu.common.basic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @ClassName LoginInfoVO
 * @Description
 * @Author nullacc
 * @Data 2020/10/15 11:22 am
 * @Version 1.0
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ApiModel(value = "LoginIngoVo", description = "login info")
public class LoginInfoVo {

    @ApiModelProperty(value = "ask for permission for joining {auth_token}")
    private String token;

    @ApiModelProperty(value = "expire time")
    private Integer expireSecond;

    @ApiModelProperty(value = "customerName")
    private String customerName;
}
