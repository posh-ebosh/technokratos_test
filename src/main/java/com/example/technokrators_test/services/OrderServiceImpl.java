package com.example.technokrators_test.services;

import com.example.technokrators_test.dto.OrderDto;
import com.example.technokrators_test.models.Order;
import com.example.technokrators_test.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductService productService;

    @Override
    public List<OrderDto> getAllOrders() {
        return OrderDto.from(orderRepository.findAll());
    }

    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String dateTime = LocalDateTime.now().format(dateTimeFormatter);
        Order order = Order.builder()
                .email(orderDto.getEmail())
                .dateTimeOfCreation(dateTime)
                .email(orderDto.getEmail())
                .orderNumber(dateTime.hashCode())
                .products(productService.getAllProductsByVendorCodes(orderDto.getProducts()))
                .build();
        orderRepository.save(order);
        return OrderDto.from(order);
    }

    @Override
    public List<OrderDto> getOrdersByEmail(String email) {
        return OrderDto.from(orderRepository.findAllByEmail(email));
    }

    @Override
    public List<OrderDto> getOrdersBetweenDate(String start, String end) {
        return OrderDto.from(orderRepository.findBetweenDate(start, end));
    }

    @Override
    public List<OrderDto> getOrdersByProduct(String vendorCode) {
        return OrderDto.from(orderRepository.findByProductsVendorCode(vendorCode));
    }
}
