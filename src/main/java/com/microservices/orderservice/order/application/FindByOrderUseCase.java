package com.microservices.orderservice.order.application;

import com.microservices.orderservice.order.domain.exception.OrderNotFoundException;
import com.microservices.orderservice.order.domain.model.Order;
import com.microservices.orderservice.order.domain.port.in.FindByIdOrderPort;
import com.microservices.orderservice.order.domain.port.out.OrderRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindByOrderUseCase implements FindByIdOrderPort {

    private final OrderRepositoryPort orderRepositoryPort;

    @Override
    public Order findById(Long id){
        return orderRepositoryPort.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }
}
