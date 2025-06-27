package io.projects.products.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseDTO {
    private Long id;
    private String title;
    private BigDecimal price;
    private Integer quantity;
    private String description;

}
