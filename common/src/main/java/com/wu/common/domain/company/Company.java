package com.wu.common.domain.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
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
@Entity

public class Company {

    @Id
    @GeneratedValue
    String companyId;

    @Column
    String companyName;

    @Column
    String companyLocation;

    @Column
    Integer companyStatus;

    @Column
    Date createdTime;

    @Column(columnDefinition = "Text")
    String companyInfo;


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Accessors(chain = true)
    @Entity
    public static class CompanyDetails {

        @Id
        @GeneratedValue
        String companyId;

        @Lob
        Byte[] businessLicense;

        @Lob
        Byte[] businessLicenseBack;

        @Column
        Integer verificationStatus;

        public enum verificaitonStatus {

        }

    }

    public enum companyStatus {

    }

}
