package com.example.smart_inventory_app.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.smart_inventory_app.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
            Optional<Product> findByName(String name);
}