package io.projects.products.service;

import io.projects.core.events.ProductCreatedEvent;
import io.projects.products.dto.ProductCreatedResponse;
import io.projects.products.dto.ProductCreationRequest;
import io.projects.products.entity.ProductEntity;
import io.projects.products.mapper.ProductsMapper;
import io.projects.products.repository.ProductRepository;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@NoArgsConstructor
public class ProductService {

    @Autowired
    private KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
    private ProductRepository productRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ProductService(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate, ProductRepository productRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.productRepository = productRepository;
    }


    public ProductCreatedResponse create(ProductCreationRequest productCreationRequest) {
        ProductEntity productEntity = new ProductEntity();
        ProductEntity product = ProductsMapper.mapToProductEntity(productEntity, productCreationRequest);
        productRepository.save(product);

        return new ProductCreatedResponse();
    }

}
