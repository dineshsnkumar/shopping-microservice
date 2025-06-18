package io.projects.products.controller;

import io.projects.products.dto.ProductCreatedResponse;
import io.projects.products.dto.ProductCreationRequest;
import io.projects.products.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductCreatedResponse> create(@RequestBody ProductCreationRequest productCreatedEvent){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(productCreatedEvent));
    }

    @GetMapping
    public ResponseEntity<List<ProductCreationRequest>> getAllProducts(){
        List<ProductCreationRequest> productDTOList = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.OK).body(productDTOList);
    }
}
