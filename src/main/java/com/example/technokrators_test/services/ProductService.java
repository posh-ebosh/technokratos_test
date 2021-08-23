package com.example.technokrators_test.services;

import com.example.technokrators_test.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProductsByVendorCodes(List<String> vendorCode);
}
