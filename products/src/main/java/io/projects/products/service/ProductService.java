package io.projects.products.service;

import io.projects.products.entity.Product;
import io.projects.products.events.ProductCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductService {

    private KafkaTemplate kafkaTemplate;

    public String create(Product product){
        String productId = "1";
        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productId, product.getTitle(), product.getPrice(), product.getQuantity());
        // TODO: save to Database
        CompletableFuture<SendResult<String, ProductCreatedEvent>> future =  kafkaTemplate.send("product-created-topic",productId, productCreatedEvent);
        future.whenComplete((res, _) -> {
            res.getRecordMetadata();
        });
        return "";
    }

}
