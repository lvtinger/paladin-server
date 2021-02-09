package org.lvtinger.paladin.account.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "account")
@EntityListeners(AuditingEntityListener.class)
public class Account implements Serializable {
    private static final long serialVersionUID = 1756903957702097928L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Column(name = "ct")
    @CreatedDate
    private Long createTime;
    @Column(name = "ut")
    @LastModifiedDate
    private Long updateTime;
    private Integer status;
    private Boolean disable;
}
