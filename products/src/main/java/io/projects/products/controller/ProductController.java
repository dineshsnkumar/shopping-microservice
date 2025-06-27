package io.projects.products.controller;

import io.projects.products.dto.ProductResponseDTO;
import io.projects.products.dto.ProductRequestDTO;
import io.projects.products.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductRequestDTO create(@RequestBody @Valid ProductRequestDTO productRequestDTO){
        productService.create(productRequestDTO);
        return productRequestDTO;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<ProductResponseDTO>> getProductById(@PathVariable Long productId){
        List<ProductResponseDTO> productDTOList = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.OK).body(productDTOList);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> productDTOList = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.OK).body(productDTOList);
    }


}
