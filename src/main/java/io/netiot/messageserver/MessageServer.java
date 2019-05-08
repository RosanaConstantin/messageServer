package io.netiot.messageserver;

import io.netiot.messageserver.configurations.KafkaChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@EnableDiscoveryClient
@EnableBinding(KafkaChannels.class)
@SpringBootApplication(exclude = ElasticsearchDataAutoConfiguration.class)
@EntityScan
public class MessageServer {

    public static void main(String[] args) {
        SpringApplication.run(MessageServer.class, args);
    }

}
