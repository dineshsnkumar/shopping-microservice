package io.projects.orders.service;

import io.projects.core.OrderStatus;
import io.projects.orders.dto.OrderRequestDTO;
import io.projects.orders.dto.OrderResponseDTO;
import io.projects.orders.entity.OrderEntity;
import io.projects.orders.mappers.OrdersMapper;
import io.projects.orders.repository.OrdersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrdersService {

    private OrdersRepository ordersRepository;

    public OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO){
        OrderEntity orderEntity = OrdersMapper.convertTOEntity(orderRequestDTO, new OrderEntity());
        OrderEntity savedOrder = ordersRepository.save(orderEntity);

        // Send kafka message to process the payment transaction

        return OrdersMapper.convertFromEntityTODTO(new OrderResponseDTO(), savedOrder);
    }
}
