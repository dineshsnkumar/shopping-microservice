package io.projects.orders.mappers;

import io.projects.core.OrderStatus;
import io.projects.orders.dto.OrderRequestDTO;
import io.projects.orders.dto.OrderResponseDTO;
import io.projects.orders.entity.OrderEntity;

public class OrdersMapper {

    public static OrderEntity convertTOEntity(OrderRequestDTO orderRequestDTO, OrderEntity orderEntity){
        orderEntity.setCustomerId(orderRequestDTO.getCustomerId());
        orderEntity.setProductId(orderRequestDTO.getProductId());
        orderEntity.setQuantity(orderRequestDTO.getQuantity());
        orderEntity.setOrderStatus(OrderStatus.CREATED);
        return orderEntity;
    }

    public static OrderResponseDTO convertFromEntityTODTO(OrderResponseDTO orderResponseDTO, OrderEntity orderEntity){
        orderResponseDTO.setCustomerId(orderEntity.getCustomerId());
        orderResponseDTO.setProductId(orderEntity.getProductId());
        orderResponseDTO.setQuantity(orderEntity.getQuantity());
        orderResponseDTO.setOrderStatus(orderEntity.getOrderStatus());
        return orderResponseDTO;
    }
}
