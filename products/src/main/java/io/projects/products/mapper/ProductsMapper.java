package io.projects.products.mapper;

import io.projects.products.dto.ProductRequestDTO;
import io.projects.products.dto.ProductResponseDTO;
import io.projects.products.entity.ProductEntity;

public class ProductsMapper {
    public static ProductEntity mapToProductEntity(ProductEntity productEntity, ProductRequestDTO productCreationRequest){
        productEntity.setTitle(productCreationRequest.getTitle());
        productEntity.setPrice(productCreationRequest.getPrice());
        productEntity.setDescription(productEntity.getDescription());
        return productEntity;
    }

    public static ProductResponseDTO mapToProductDTO(ProductEntity productEntity, ProductResponseDTO productResponseDTO){
        productResponseDTO.setTitle(productEntity.getTitle());
        productResponseDTO.setPrice(productEntity.getPrice());
        productResponseDTO.setDescription(productEntity.getDescription());
        productResponseDTO.setId(productEntity.getProductId());
        return productResponseDTO;
    }
}
