package io.netiot.messageserver.mappers;

import io.netiot.messageserver.entities.Msg;
import io.netiot.messageserver.models.MessageModel;


public class MessageMapper {

    private MessageMapper() {
    }

    public static MessageModel toModel(final Msg message) {
        return MessageModel.builder()
                .id(message.getId())
                .name(message.getName())
                .phone(message.getPhone())
                .message(message.getMessage())
                .build();
    }
}



