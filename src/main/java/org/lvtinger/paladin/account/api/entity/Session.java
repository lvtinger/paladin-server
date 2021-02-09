package org.lvtinger.paladin.account.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.time.DateUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

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
    private String device;
    @Column(name = "uid")
    private Long userId;
    private Boolean disable;
    private Date expiry;

    public boolean dead(){
        return  !this.disable || this.expiry.getTime() > System.currentTimeMillis();
    }

    public static Session build(Long userId, String device) {
        Session session = new Session();
        session.setUserId(userId);
        session.setDevice(device);
        session.setToken(UUID.randomUUID().toString());
        session.setDisable(false);
        session.setExpiry(DateUtils.addDays(new Date(), EXPIRY_DAY_COUNT));
        return session;
    }

    public Session refresh() {
        this.token = UUID.randomUUID().toString();
        this.expiry = DateUtils.addDays(new Date(), EXPIRY_DAY_COUNT);
        this.disable = true;
        return this;
    }

    private static final int EXPIRY_DAY_COUNT = 2;
}
