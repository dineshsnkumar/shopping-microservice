package io.projects.products.service;

import io.projects.products.entity.Product;
import io.projects.products.events.ProductCreatedEvent;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@NoArgsConstructor
public class ProductService {

    @Autowired
    private KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ProductService(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public String create(Product product) {
        String productId = "1";
        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productId, product.getTitle(), product.getPrice(), product.getQuantity());
        // TODO: save to Database
        CompletableFuture<SendResult<String, ProductCreatedEvent>> future = kafkaTemplate.send("product-created-topic", productId, productCreatedEvent);
        future.whenComplete((res, exception_) -> {
            if (exception_ != null) {
                logger.error("Error sending the topic " + exception_.getMessage());
            } else {
                logger.info("Message sent to kafka " + res.getRecordMetadata());
            }
        });
        return "";
    }

}
