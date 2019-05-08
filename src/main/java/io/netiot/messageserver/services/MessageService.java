package io.netiot.messageserver.services;


import com.twilio.Twilio;
import io.netiot.messageserver.entities.Msg;
import io.netiot.messageserver.mappers.MessageMapper;
import io.netiot.messageserver.models.MessageModel;
import io.netiot.messageserver.models.events.CreateMessageEvent;
import io.netiot.messageserver.repositiories.MessageRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<MessageModel> getMessages(final Integer pageNumber, final Integer pageSize) {
        final Pageable pageable = PageRequest.of(pageNumber, pageSize, new Sort(Sort.Direction.ASC, "name"));
        return messageRepository.findAll(pageable).stream()
                .map(MessageMapper::toModel)
                .collect(Collectors.toList());
    }

    public void intercept(final CreateMessageEvent createMessageEvent) {
        Msg message = Msg.builder()
                .id(createMessageEvent.getId())
                .name(createMessageEvent.getName())
                .phone(createMessageEvent.getPhone())
                .message(createMessageEvent.getMessage())
                .build();

            messageRepository.save(message);
            System.out.println("message server");
            TwilioMessageCreator.create(createMessageEvent.getPhone(), createMessageEvent.getMessage());
    }
}
