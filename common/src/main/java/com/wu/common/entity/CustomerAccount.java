package com.wu.common.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


/**
 * @author wuhjie
 */
@Builder
@Entity
@Table(name = "customerAccount", indexes = {@Index(name = "customer", unique = true, columnList = "account")})
@SQLDelete(sql = "update accountCustomer set deketed = 1 where account = ?")
@Where(clause = "deleted = 0")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CustomerAccount extends AbstractEntity{

    @Column(name = "account", nullable = false, updatable = false, length = 20)
    private String customerId;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Column(name = "tel", length = 11)
    private String tel;
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

}
