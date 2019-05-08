package io.netiot.messageserver.controllers;

import io.netiot.messageserver.services.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity getMessages(@RequestParam(name = "page", defaultValue = "0") final Integer pageNumber,
                                      @RequestParam(name = "size", defaultValue = "10") final Integer pageSize){
        return ResponseEntity.ok(messageService.getMessages(pageNumber, pageSize));
    }
}


