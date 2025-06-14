package io.projects.kafka.EmailNotification.events;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product-created")
@NoArgsConstructor
@Getter @Setter
public class ProductCreatedEntity {
    @Id
    @GeneratedValue
    private Long ID;
    @Column(unique = true, nullable = false)
    private String messageId;
    @Column(nullable = false)
    private String productId;

    public ProductCreatedEntity(String messageId, String productId) {
        this.messageId = messageId;
        this.productId = productId;
    }
}
