package org.lvtinger.paladin.message.api.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MessageType {
    text(1), image(2);
    public final int value;

    MessageType(int value) {
        this.value = value;
    }

    private static final List<MessageType> messageTypes = Arrays.stream(MessageType.values()).collect(Collectors.toList());

    public static MessageType parse(Integer value) {
        if (value == null) {
            return null;
        }

        return messageTypes.stream().filter(x -> x.value == value).findFirst().orElse(null);
    }

    public static MessageType parse(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }

        return messageTypes.stream().filter(x -> x.name().equals(name)).findFirst().orElse(null);
    }
}
