package io.projects.kafka.EmailNotification.repository;

import io.projects.kafka.EmailNotification.events.ProductCreatedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCreatedRepository extends JpaRepository<ProductCreatedEntity, Long> {
}
