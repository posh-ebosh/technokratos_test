package com.example.technokrators_test.services;

import com.example.technokrators_test.dto.OrderDto;
import com.example.technokrators_test.models.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders();

    OrderDto addOrder(OrderDto orderDto);

    List<OrderDto> getOrdersByEmail(String email);

    List<OrderDto> getOrdersBetweenDate(String start, String end);

    List<OrderDto> getOrdersByProduct(String vendorCode);
}
