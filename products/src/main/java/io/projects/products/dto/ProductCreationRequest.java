package io.projects.products.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ProductCreationRequest {
    private String title;
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private BigDecimal price;
    private Integer quantity;
    private String description;
}
