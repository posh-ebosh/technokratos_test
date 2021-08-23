package com.example.technokrators_test.repositories;

import com.example.technokrators_test.models.Order;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // получение списка заказов по email
    List<Order> findAllByEmail(String email);

    // получение списка заказов, в которых есть определенный товар (не работает)
    @Query("select orders from Order orders join orders.products product where product.vendorCode = :vendorCode")
    List<Order> findByProductsVendorCode(@Param("vendorCode") String vendorCode);

    // получение списка заказов между двумя датами
    @Query("select orders from Order orders where orders.dateTimeOfCreation between :start and :end")
    List<Order> findBetweenDate(String start, String end);
}
