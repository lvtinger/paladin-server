package org.lvtinger.paladin.relation.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "relation")
public class Relation implements Serializable {
    private static final long serialVersionUID = -3968608607311231128L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ownerId;
    private Long targetId;
    private String remark;
    private Integer type;
    private Integer status;
}
