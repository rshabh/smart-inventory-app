package com.example.smart_inventory_app.dto.product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    
    private int id;
    private String name;
    private Long price;
    private int quantity;
    private String category;
    private String supplier;
    private String supplierMail;

}
