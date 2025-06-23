package io.projects.products.service;

import io.projects.core.events.ProductCreatedEvent;
import io.projects.products.dto.ProductResponseDTO;
import io.projects.products.dto.ProductRequestDTO;
import io.projects.products.entity.ProductEntity;
import io.projects.products.mapper.ProductsMapper;
import io.projects.products.repository.ProductRepository;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
    private final ProductRepository productRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductResponseDTO create(ProductRequestDTO productCreationRequest) {
        ProductEntity productEntity = new ProductEntity();
        ProductEntity product = ProductsMapper.mapToProductEntity(productEntity, productCreationRequest);
        ProductEntity savedProduct = productRepository.save(product);

        return new ProductResponseDTO();
    }

}
