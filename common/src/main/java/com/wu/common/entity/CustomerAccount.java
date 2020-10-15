package com.wu.common.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author nullacc
 */
@Builder
@Entity
@Table()
@SQLDelete(sql = "")
@Where(clause = "deleted = 0")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CustomerAccount {

    @Column(name = "account", nullable = false, updatable = false, length = 20)
    private String customerId;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Column(name = "tel", length = 11)
    private String tel;


}
