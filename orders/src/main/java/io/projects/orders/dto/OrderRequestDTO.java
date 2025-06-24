package io.projects.orders.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderRequestDTO {
    @NotNull
    private int customerId;
    @NotNull
    private UUID productId;
    @NotNull
    @Positive
    private int quantity;

}
