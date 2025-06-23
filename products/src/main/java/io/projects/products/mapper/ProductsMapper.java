package io.projects.products.mapper;

import io.projects.products.dto.ProductRequestDTO;
import io.projects.products.entity.ProductEntity;

public class ProductsMapper {
    public static ProductEntity mapToProductEntity(ProductEntity productEntity, ProductRequestDTO productCreationRequest){
        productEntity.setTitle(productCreationRequest.getTitle());
        productEntity.setPrice(productCreationRequest.getPrice());
        productEntity.setDescription(productEntity.getDescription());
        return productEntity;
    }
}
