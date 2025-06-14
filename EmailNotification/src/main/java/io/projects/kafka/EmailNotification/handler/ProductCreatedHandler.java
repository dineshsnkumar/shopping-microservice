package io.projects.kafka.EmailNotification.handler;


import io.projects.core.events.ProductCreatedEvent;
import io.projects.kafka.EmailNotification.repository.ProductCreatedRepository;
import io.projects.kafka.EmailNotification.events.ProductCreatedEntity;
import io.projects.kafka.EmailNotification.exceptions.NonRetryableExceptions;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "product-created-topic")
@Transactional
public class ProductCreatedHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private ProductCreatedRepository productCreatedRepository;

    public ProductCreatedHandler(ProductCreatedRepository productCreatedRepository){
        this.productCreatedRepository = productCreatedRepository;
    }

    @KafkaHandler
    public void handleProductEvent(@Payload ProductCreatedEvent productCreatedEvent, @Header("messageId") String messageId){
        LOGGER.info("Product created" + productCreatedEvent.getTitle());

        try{
            productCreatedRepository.save(new ProductCreatedEntity(messageId, productCreatedEvent.getId()));
        } catch (DataIntegrityViolationException exception){
            throw new NonRetryableExceptions(exception);
        }
    }
}
