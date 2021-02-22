package org.lvtinger.paladin.account.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "verify_code")
public class VerifyCode implements Serializable {
    private static final long serialVersionUID = -4970051142262842969L;
    @Id
    private String mobile;
    private Integer code;
    @Column(name = "ut")
    private Date updateTime;

    public boolean validate(Integer verifyCode) {
        if (this.updateTime == null || this.updateTime.before(new Date())) {
            return false;
        }
        return Objects.equals(verifyCode, this.code);
    }
}
