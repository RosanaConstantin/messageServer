package io.netiot.messageserver.configurations;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface KafkaChannels {

    String NOTIFICATION_INPUT = "notification";

    @Input(KafkaChannels.NOTIFICATION_INPUT)
    MessageChannel notificationInput();
}
