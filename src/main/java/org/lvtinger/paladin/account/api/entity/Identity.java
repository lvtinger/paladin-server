package org.lvtinger.paladin.account.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "identity")
public class Identity implements Serializable {
    private static final long serialVersionUID = -4141221572828961774L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mobile;
}
