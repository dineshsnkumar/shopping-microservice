package io.projects.products.controller;

import io.projects.products.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ProductDTO product){
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> productDTOList = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.OK).body(productDTOList);
    }
}
