package io.github.luaprogrammer.trade_map.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerComponent {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, Object> customKafkaTemplate;

    @Autowired
    public KafkaProducerComponent(KafkaTemplate<String, String> kafkaTemplate, KafkaTemplate<String, Object> customKafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.customKafkaTemplate = customKafkaTemplate;
    }

    public void sendMessage(String message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }

    public void sendCustomMessage(Object message, String topicName) { //vai receber qualquer objeto e transformar em json
        customKafkaTemplate.send(topicName, message);
    }
}