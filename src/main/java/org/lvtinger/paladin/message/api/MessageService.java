package org.lvtinger.paladin.message.api;

import org.lvtinger.paladin.message.api.entity.Message;
import org.lvtinger.paladin.value.Result;

import java.util.List;

public interface MessageService {
    Result<Long> sendMessage(Long sender, Long target, Integer type, String content);

    Result<Boolean> readMessage(Long messageId, Long target);

    List<Message> receiveMessage(Long owner);
}