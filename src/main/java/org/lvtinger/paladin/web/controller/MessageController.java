package org.lvtinger.paladin.web.controller;

import org.lvtinger.paladin.message.api.MessageService;
import org.lvtinger.paladin.message.api.entity.Message;
import org.lvtinger.paladin.value.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
    @Resource
    private MessageService messageService;

    @RequestMapping(value = "/send.page")
    public Result<Long> send(Long sender, Long target, Integer type, String content) {
        return messageService.sendMessage(sender, target, type, content);
    }

    @RequestMapping(value = "/receive.page")
    public Result<ArrayList<Message>> receive(Long owner) {
        ArrayList<Message> messages = new ArrayList<>(messageService.receiveMessage(owner));
        return Result.success(messages);
    }
}