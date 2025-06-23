package io.projects.products.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductRequestDTO {
    private String title;
    private BigDecimal price;
    private Integer quantity;
    private String description;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(String title, BigDecimal price, Integer quantity, String description) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductRequestDTO{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                '}';
    }
}
