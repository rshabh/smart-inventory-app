package com.example.smart_inventory_app.service;
import java.util.List;

import com.example.smart_inventory_app.dto.product.ProductRequestDTO;
import com.example.smart_inventory_app.dto.product.ProductResponseDTO;



public interface ProductService {

    ProductResponseDTO createProduct(ProductRequestDTO productDTO);
    List<ProductResponseDTO> getProducts();
;

}
