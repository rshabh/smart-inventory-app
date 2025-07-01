package com.example.smart_inventory_app.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.smart_inventory_app.dto.product.ProductDTO;
import com.example.smart_inventory_app.service.ProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ProductController {

    @Autowired
    ProductService ps;

    @PostMapping("/products")
    public ProductDTO createProduct(@RequestBody ProductDTO pdto) {
        return ps.createProduct(pdto);
    }
    

    @PutMapping("/products/{id}")
    public ProductDTO updateProduct(@PathVariable int id , @RequestBody ProductDTO pd ) {
        ps.updateProduct(id, pd);
        return pd;
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        ps.deleteProduct(id);
    }

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        return ps.getAllProducts();
    }

    @GetMapping("/products/price-below/{threshold}")
    public List<ProductDTO> getProductsBelowPriceThreshold(@PathVariable int threshold) {
        return ps.getProductsBelowPriceThreshold(threshold);
    }

     @GetMapping("/products/category/{category}")
    public List<ProductDTO> getProductsByCategory(@PathVariable String category) {
        return ps.getProductsByCategory(category);
    }


}

