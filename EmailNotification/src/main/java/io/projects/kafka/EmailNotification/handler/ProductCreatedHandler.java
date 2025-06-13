package io.projects.kafka.EmailNotification.handler;


import io.projects.core.events.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "product-created-topic")
public class ProductCreatedHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @KafkaHandler
    public void handleProductEvent(ProductCreatedEvent productCreatedEvent){
        LOGGER.info("Product created" + productCreatedEvent.getTitle());
    }
}
