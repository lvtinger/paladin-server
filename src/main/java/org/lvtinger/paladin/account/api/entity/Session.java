package org.lvtinger.paladin.account.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "session")
public class Session implements Serializable {
    private static final long serialVersionUID = 7123991096017791748L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    @Column(name = "uid")
    private Long userId;
    private Boolean disable;
    private Date expiry;
    @Column(name = "ct")
    @CreatedDate
    private Date createTime;
    @Column(name = "ut")
    @LastModifiedDate
    private Date updateTime;
}
