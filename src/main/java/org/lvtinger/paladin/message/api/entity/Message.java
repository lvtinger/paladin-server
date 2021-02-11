package org.lvtinger.paladin.message.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "message")
public class Message implements Serializable {
    private static final long serialVersionUID = 2475691341600746506L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long owner;
    private Long sender;
    private Long target;
    private String content;
    private Integer type;
    private Integer status;
    private Long createTime;
    private Long updateTime;
    private String uniqueId;

    public Message resolve() {
        Message message = new Message();
        message.sender = this.sender;
        message.owner = this.target;
        message.target = this.target;
        message.content = this.content;
        message.type = this.type;
        message.createTime = this.createTime;
        message.updateTime = this.updateTime;
        message.uniqueId = this.uniqueId;
        return message;
    }

    public static Message build(Long sender, Long target, String content, Integer type) {
        Message message = new Message();
        message.sender = sender;
        message.owner = sender;
        message.target = target;
        message.content = content;
        message.type = type;
        message.createTime = System.currentTimeMillis();
        message.updateTime = message.createTime;
        message.uniqueId = UUID.randomUUID().toString();
        return message;
    }


}