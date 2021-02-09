package org.lvtinger.paladin.account.api.entity;

import lombok.Getter;
import lombok.Setter;
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
    private Long updateTime;
    private Integer status;
    private Boolean disable;


    public static Account build(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.disable = false;
        account.status = 1;
        return account;
    }
}
