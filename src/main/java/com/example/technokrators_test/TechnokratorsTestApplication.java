package com.example.technokrators_test;

import com.example.technokrators_test.models.Order;
import com.example.technokrators_test.models.Product;
import com.example.technokrators_test.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TechnokratorsTestApplication {

    public static void main(String[] args) {SpringApplication.run(TechnokratorsTestApplication.class, args);}

}
