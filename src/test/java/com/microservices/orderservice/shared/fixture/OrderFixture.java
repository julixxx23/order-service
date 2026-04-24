package com.microservices.orderservice.shared.fixture;

import com.microservices.orderservice.order.domain.model.Order;
import com.microservices.orderservice.shared.domain.model.PageDomain;

import java.time.LocalDateTime;
import java.util.List;

public class OrderFixture {

    public static Order aOrderValid(){
        return Order.builder()
                .idOrder(1L)
                .idUser(1L)
                .details("Product valid")
                .createdAt(LocalDateTime.of(2026, 8, 12, 10, 8))
                .build();
    }

    public static Order  aOrderWithoutId(){
        return Order.builder()
                .idUser(1L)
                .details("Product valid")
                .createdAt(LocalDateTime.of(2026, 3, 12, 10, 11))
                .build();
    }

    public static List<Order> aOrderList(){
        return List.of(aOrderValid(), Order.builder()
                .idOrder(1L)
                .idUser(1L)
                .details("Product valid")
                .createdAt(LocalDateTime.of(2026, 3, 12, 10, 11))
                .build());
    }
    public static PageDomain<Order> aPageDomainOfOrder(){
        return new PageDomain<>(aOrderList(), 0, 1, 2L);
    }
}

