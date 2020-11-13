package com.wu.common.domain.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName Company
 * @Description
 * @Author wuhjie
 * @Data 2020/10/27 11:13 am
 * @Version 1.0
 **/

//@AllArgsConstructor

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

    @Column
    String companyInfo;

    public Company(String companyName, String companyLocation, Integer companyStatus, Date createdTime, String companyInfo) {
        this.companyId = UUID.randomUUID().toString();
        this.companyName = companyName;
        this.companyLocation = companyLocation;
        this.companyStatus = companyStatus;
        this.createdTime = createdTime;
        this.companyInfo = companyInfo;
    }

    public Company() {

    }

    //    @AllArgsConstructor
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
        verificaitonStatus verificationStatus;

    public CompanyDetails(Byte[] businessLicense, Byte[] businessLicenseBack, verificaitonStatus verificationStatus) {
        this.companyId = getCompanyId();
        this.businessLicense = businessLicense;
        this.businessLicenseBack = businessLicenseBack;
        this.verificationStatus = verificationStatus;
    }

    public enum verificaitonStatus {
            unverified(0, "this company hasn't be vatified"),
            verified(1, "this company is verified"),
            warning (2, "the company can't not be trusted");

            verificaitonStatus(int code, String msg) {
            }
        }

    }

    public enum companyStatus {

    }

}
