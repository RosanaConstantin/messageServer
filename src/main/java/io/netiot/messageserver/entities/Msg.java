package io.netiot.messageserver.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Message")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Msg {

    @Id
    @Column(name = "id")
    private Long id;

    private String name;

    private String phone;

    private String message;

}
