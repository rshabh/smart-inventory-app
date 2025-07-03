package com.example.smart_inventory_app.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.smart_inventory_app.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer>{
    Optional<Supplier> findBySupplierMail(String supplierMail);

    
}



