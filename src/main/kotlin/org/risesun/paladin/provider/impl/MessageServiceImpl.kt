package org.risesun.paladin.provider.impl

import org.risesun.paladin.provider.entity.Message
import org.risesun.paladin.provider.api.MessageService
import org.risesun.paladin.provider.dao.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class MessageServiceImpl : MessageService {

    @Autowired
    private lateinit var messageRepository: MessageRepository

    override fun save(message: Message) {
        val save = messageRepository.save(message.build())
        messageRepository.save(save.clone())
    }

    override fun cancel(member: Long, messageId: String) {
        if (!messageId.startsWith(member.toString())) {
            return
        }
        val message = messageRepository.findById(messageId).orElse(null) ?: return
        val messages = messageRepository.findBySerialId(message.serialId!!)
        messageRepository.saveAll(messages)
    }

    override fun read(member: Long, messageId: String) {
        if (!messageId.startsWith(member.toString())) {
            return
        }
        val receiveMessage = messageRepository.findById(messageId).orElse(null) ?: return
        val otherId = receiveMessage.getOtherId()
        val sendMessage = messageRepository.findById(otherId).orElse(null) ?: return
        sendMessage.status = Message.STATUS_READED
        messageRepository.save(sendMessage)
    }

    override fun delete(member: Long, messageIds: MutableList<String>) {
        messageIds.forEach {
            if (!it.startsWith(member.toString())) {
                return
            }
        }
        val messages = messageRepository.findAllById(messageIds)
        messages.forEach { it.disabled = true }
        messageRepository.saveAll(messages)
    }

    override fun load(member: Long): MutableList<Message> {
        return messageRepository.findByMember(member)
    }

}