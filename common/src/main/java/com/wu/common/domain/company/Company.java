package com.wu.common.domain.company;

import com.wu.common.utils.ImageUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Blob;
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
@Entity

public class Company {

    @Id
    @GeneratedValue
    String companyId;

    @Column
    String companyLocation;

    @Column
    Integer companyStatus;

    @Column
    Integer verificationStatus;

    @Column
    Date createdTime;


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
        Blob businessLicense;

        @Lob
        Blob businessLicenseBack;

        @Column(columnDefinition = "Text")
        String companyInfo;

    }

}
