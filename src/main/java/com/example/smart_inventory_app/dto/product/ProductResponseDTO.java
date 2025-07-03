package com.example.smart_inventory_app.dto.product;

import com.example.smart_inventory_app.enums.StatusField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponseDTO {
    
    private int id;
    private String name;
    private Long price;
    private int quantity;
    private String category;
    private StatusField statusField;
    private String supplierName;
    private String supplierMail;
    private String supplierPhoneNumber;

}
