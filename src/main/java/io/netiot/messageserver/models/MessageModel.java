package io.netiot.messageserver.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageModel {

    private Long id;

    private String name;

    private String phone;

    //private Long organizationId;

    private String message;
}
