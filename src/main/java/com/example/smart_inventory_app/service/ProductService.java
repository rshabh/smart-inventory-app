package com.example.smart_inventory_app.service;
import java.util.*;
import com.example.smart_inventory_app.dto.product.ProductDTO;



public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(int id, ProductDTO productDTO);
    void deleteProduct(int id);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getProductsBelowPriceThreshold(int threshhold);
    List<ProductDTO> getProductsByCategory(String category);

}
