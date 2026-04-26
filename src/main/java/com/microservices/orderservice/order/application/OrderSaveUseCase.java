package com.microservices.orderservice.order.application;

import com.microservices.orderservice.order.domain.model.Order;
import com.microservices.orderservice.order.domain.port.in.SaveOrderPort;
import com.microservices.orderservice.order.domain.port.out.OrderRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderSaveUseCase implements SaveOrderPort {

    private final OrderRepositoryPort orderRepositoryPort;

    @Override
    public Order save(Order order) {
        return orderRepositoryPort.save(order);
    }
}