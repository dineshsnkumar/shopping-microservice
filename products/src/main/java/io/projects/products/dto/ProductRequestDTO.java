package io.projects.products.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;

@Data
public class ProductRequestDTO {
    private String title;
    private BigDecimal price;
    private Integer quantity;
    private String description;

}
