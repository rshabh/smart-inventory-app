package com.example.smart_inventory_app.service;
import java.util.List;

import com.example.smart_inventory_app.dto.supplier.SupplierDTO;

public interface SupplierService {

    SupplierDTO createSupplier(SupplierDTO supplierDTO);
    List<SupplierDTO> getSuppliers();

}
