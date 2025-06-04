package io.projects.products.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ProductDTO {
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
