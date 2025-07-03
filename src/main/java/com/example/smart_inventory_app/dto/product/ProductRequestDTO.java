package com.example.smart_inventory_app.dto.product;


import com.example.smart_inventory_app.dto.supplier.SupplierDTO;
import com.example.smart_inventory_app.enums.StatusField;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class ProductRequestDTO {

    private String name;
    private Long price;
    private int quantity;
    private String category;
    private StatusField statusField;

    private SupplierDTO supplierdto;

}
