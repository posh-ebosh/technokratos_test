package com.example.technokrators_test.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // артикул
    private String vendorCode;

    // название товара
    private String name;

    // признак удаленности
    private boolean isDeleted;

    // цена
    private Double price;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
}
