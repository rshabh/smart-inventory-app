package com.example.smart_inventory_app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.smart_inventory_app.dto.product.ProductRequestDTO;
import com.example.smart_inventory_app.dto.product.ProductResponseDTO;
import com.example.smart_inventory_app.service.ProductserviceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class ProductController {

    @Autowired
    ProductserviceImpl ps;

    @PostMapping("/products")
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return ps.createProduct(productRequestDTO);
    }


    @GetMapping("/products")
    public List<ProductResponseDTO> getProducts() {
        return ps.getProducts();
    }
    
    




}

