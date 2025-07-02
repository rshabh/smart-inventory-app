package com.example.smart_inventory_app.model;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.example.smart_inventory_app.enums.LogType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InventoryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private LogType lt;

    private int changeinStock;

    @CreationTimestamp
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    Supplier supplier;

}
