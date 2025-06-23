package io.projects.products.controller;

import io.projects.products.dto.ProductResponseDTO;
import io.projects.products.dto.ProductRequestDTO;
import io.projects.products.service.ProductService;
import jakarta.validation.Valid;
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
    public ResponseEntity<ProductResponseDTO> create(@RequestBody @Valid ProductRequestDTO productCreatedEvent){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(productCreatedEvent));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<ProductRequestDTO>> getAllProducts(@PathVariable Long productId){
        List<ProductRequestDTO> productDTOList = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.OK).body(productDTOList);
    }
}
