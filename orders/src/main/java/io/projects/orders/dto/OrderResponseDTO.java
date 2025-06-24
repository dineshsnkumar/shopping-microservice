package io.projects.orders.dto;

import io.projects.core.OrderStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderResponseDTO {
    private int customerId;
    private UUID productId;
    private int quantity;
    private OrderStatus orderStatus;
}
