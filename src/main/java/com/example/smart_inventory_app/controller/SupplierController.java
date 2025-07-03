package com.example.smart_inventory_app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.smart_inventory_app.dto.supplier.SupplierDTO;
import com.example.smart_inventory_app.service.SupplierServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class SupplierController {

    @Autowired
    SupplierServiceImpl ss;


    @PostMapping("/suppliers")
    public SupplierDTO postMethodName(@RequestBody SupplierDTO supplierDTO) {
        return ss.createSupplier(supplierDTO);
    }


    @GetMapping("/suppliers")
    public List<SupplierDTO> getSuppliers() {
        return ss.getSuppliers();
    }
    
    

    
}
