package com.example.technokrators_test.repositories;

import com.example.technokrators_test.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select product from Product product where product.vendorCode = :vendorCode")
    List<Product> findProductByVendorCode(@Param("vendorCode") String vendorCode);
}
