package io.netiot.messageserver.services;

import io.netiot.messageserver.configurations.KafkaChannels;
import io.netiot.messageserver.models.events.CreateMessageEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Slf4j
@Service
//@RequiredArgsConstructor
public class KafkaMessageReceiverService {

    private final MessageService messageService;

    public KafkaMessageReceiverService(MessageService messageService) {
        this.messageService = messageService;
    }

    @StreamListener(KafkaChannels.NOTIFICATION_INPUT)
    public void receiveEvents(final CreateMessageEvent createMessageEvent) {
        messageService.intercept(createMessageEvent);
       // acknowledgment.acknowledge();
        log.info("Message received: " + createMessageEvent.toString());
    }

}