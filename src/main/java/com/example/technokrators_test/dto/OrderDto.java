package com.example.technokrators_test.dto;

import com.example.technokrators_test.models.Order;
import com.example.technokrators_test.models.Product;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class OrderDto {
    private String dateTimeOfCreation;
    private int orderNumber;
    private String email;
    private List<String> products;

    public static OrderDto from(Order order){
        OrderDto result = OrderDto.builder()
                .dateTimeOfCreation(order.getDateTimeOfCreation())
                .orderNumber(order.getOrderNumber())
                .email(order.getEmail())
                .build();
        if (order.getProducts() != null){
            result.setProducts(order.getProducts().stream().map(Product::getVendorCode).collect(Collectors.toList()));
        }
        return result;
    }

    public static List<OrderDto> from(List<Order> orders){
        return orders.stream().map(OrderDto::from).collect(Collectors.toList());
    }

}
