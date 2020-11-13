package com.wu.common.domain.customer;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;


/**
 * @author wuhjie
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity

public class Customer {

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

    @Column
    private String password;

    public Customer(String nickname, Integer grade, String tel, String location, Integer status, Date createdTime, Integer gender, Date birthday,String password) {
        this.customerId = UUID.randomUUID().toString();
        this.nickname = nickname;
        this.grade = grade;
        this.tel = tel;
        this.location = location;
        this.status = status;
        this.createdTime = createdTime;
        this.gender = gender;
        this.birthday = birthday;
        this.password = password;
    }
}
