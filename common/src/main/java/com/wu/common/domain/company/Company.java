package com.wu.common.domain.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

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

    @Id
    @GeneratedValue
    UUID companyId;

    @Column
    String companyLocation;

    @Column
    Integer companyStatus;

    @Column
    Integer verificationStatus;

    @Column
    Date createdTime;

}
