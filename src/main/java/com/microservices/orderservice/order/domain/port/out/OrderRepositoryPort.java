package com.microservices.orderservice.order.domain.port.out;

import com.microservices.orderservice.order.domain.model.Order;
import com.microservices.orderservice.shared.domain.model.PageDomain;

import java.util.Optional;

public interface OrderRepositoryPort {

    Order save(Order order);
    PageDomain<Order> list (int page, int size);
    Optional<Order> findById(Long id);
}
