package io.projects.orders.controllers;

import io.projects.orders.dto.OrderRequestDTO;
import io.projects.orders.dto.OrderResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public OrderResponseDTO placeOrder(@RequestBody @Valid OrderRequestDTO createOrderDTO){
        return new OrderResponseDTO();
    }
}
