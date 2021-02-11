package org.lvtinger.paladin.message.impl;

import org.lvtinger.paladin.message.api.MessageService;
import org.lvtinger.paladin.message.api.entity.Message;
import org.lvtinger.paladin.message.repo.MessageRepository;
import org.lvtinger.paladin.value.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Result<Long> sendMessage(Long sender, Long target, Integer type, String content) {
        Message message = Message.build(sender, target, content, type);
        messageRepository.save(message);
        messageRepository.save(message.resolve());
        return Result.success(message.getId());
    }


    @Override
    public Result<Boolean> readMessage(Long messageId, Long target) {
        Message targetMessage = messageRepository.getOne(messageId);
        if(targetMessage.getOwner().equals(target)){
            List<Message> messages = messageRepository.getMessageByUniqueId(targetMessage.getUniqueId());
            Message sourceMessage = messages.stream().filter(x -> !x.getId().equals(messageId)).findFirst().orElse(null);
            if(sourceMessage != null){
                sourceMessage.setStatus(2);
                messageRepository.save(sourceMessage);
            }
        }

        return Result.warning();
    }

    @Override
    public List<Message> receiveMessage(Long owner) {
        return messageRepository.getMessageByOwner(owner);
    }
}
