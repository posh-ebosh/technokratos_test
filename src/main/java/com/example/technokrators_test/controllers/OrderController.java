package com.example.technokrators_test.controllers;

import com.example.technokrators_test.dto.OrderDto;
import com.example.technokrators_test.models.Order;
import com.example.technokrators_test.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<OrderDto> getOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping(value = "/orders/find_by_email", params = "email")
    public List<OrderDto> getOrdersByEmail(@RequestParam("email") String email){
            return orderService.getOrdersByEmail(email);
    }

    @GetMapping(value = {"/orders/between_dates"}, params = {"start", "end"})
    public List<OrderDto> getOrdersBetweenDate(@Param("start")String start, @Param("end")String end){
        return orderService.getOrdersBetweenDate(start, end);
    }

    @GetMapping(value = "/orders/find_by_code", params = "code")
    public List<OrderDto> getOrdersByProduct(@Param("code") String vendorCode){
        return orderService.getOrdersByProduct(vendorCode);
    }

    @PostMapping("/orders")
    public OrderDto addOrder(@RequestBody OrderDto orderDto){
        OrderDto result = orderService.addOrder(orderDto);
        return result;
    }
}
