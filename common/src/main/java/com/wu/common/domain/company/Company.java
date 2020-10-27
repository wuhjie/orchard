package com.wu.common.domain.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @ClassName Company
 * @Description
 * @Author wuhjie
 * @Data 2020/10/27 11:13 am
 * @Version 1.0
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Company {

    String companyId;

    String companyLocation;

    Integer companyStatus;

    Integer verificationStatus;

    Date createdTime;
}
