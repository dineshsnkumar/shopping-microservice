package io.projects.core.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProductCreatedEvent {
    private String id;
    private String title;
    private BigDecimal price;
    private Integer quantity;

}
