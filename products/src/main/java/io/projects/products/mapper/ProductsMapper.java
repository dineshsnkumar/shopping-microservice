package io.projects.products.mapper;

import io.projects.core.events.ProductCreatedEvent;
import io.projects.products.dto.ProductCreatedResponse;
import io.projects.products.dto.ProductCreationRequest;
import io.projects.products.entity.ProductEntity;

public class ProductsMapper {
    public static ProductEntity mapToProductEntity(ProductEntity productEntity, ProductCreationRequest productCreationRequest){
        productEntity.setTitle(productCreationRequest.getTitle());
        productEntity.setPrice(productCreationRequest.getPrice());
        productEntity.setDescription(productEntity.getDescription());
        return productEntity;
    }
}
