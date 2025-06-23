package io.projects.products.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@Table(name = "products")
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String title;
    private BigDecimal price;
    private Integer quantity;
    private String description;
}
