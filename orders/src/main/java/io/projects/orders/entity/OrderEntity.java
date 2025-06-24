package io.projects.orders.entity;

import io.projects.core.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "orders")
@Builder
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "customerId")
    private int customerId;
    @Column(name = "productId")
    private UUID productId;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "status")
    private OrderStatus orderStatus;
}
