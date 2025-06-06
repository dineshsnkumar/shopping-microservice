package io.projects.products.controller;

import io.projects.products.dto.ProductDTO;
import io.projects.products.entity.Product;
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
    public ResponseEntity<String> create(@RequestBody ProductDTO productDTO){
        Product product = new Product(productDTO.getTitle(), productDTO.getPrice(), productDTO.getQuantity());
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> productDTOList = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.OK).body(productDTOList);
    }
}
