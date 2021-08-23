package com.example.technokrators_test.services;

import com.example.technokrators_test.models.Product;
import com.example.technokrators_test.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProductsByVendorCodes(List<String> vendorCodes) {
        List<Product> products = new ArrayList<>();
        for(String vendorCode : vendorCodes){
            products.add(productRepository.findProductByVendorCode(vendorCode).get(0));
        }
        return products;
    }
}
