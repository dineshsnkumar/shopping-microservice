package io.projects.products.entity;

import lombok.*;

import java.math.BigDecimal;

@Data@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class Product {
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
