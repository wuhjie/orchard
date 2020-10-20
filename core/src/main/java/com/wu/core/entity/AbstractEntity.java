package com.wu.core.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @ClassName AbstractEntity
 * @Description
 * @Author wuhjie
 * @Data 2020/10/19 4:06 pm
 * @Version 1.0
 **/
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @Column(columnDefinition = "bit default 0")
    private Boolean deleted;



}
