package org.lvtinger.paladin.profile.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "profile")
@EntityListeners(AuditingEntityListener.class)
public class Profile implements Serializable {
    private static final long serialVersionUID = 7662529232398300653L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String avatar;
    private String realName;
    private Integer gender;
    private Date birthday;
}
