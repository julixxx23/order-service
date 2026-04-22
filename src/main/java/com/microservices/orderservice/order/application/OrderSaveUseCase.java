package com.microservices.orderservice.order.application;

import com.microservices.orderservice.order.domain.model.Order;
import com.microservices.orderservice.order.domain.port.in.SaveOrderPort;
import com.microservices.orderservice.order.domain.port.out.OrderRepositoryPort;
import com.microservices.orderservice.order.infrastructure.adapter.client.UserClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderSaveUseCase implements SaveOrderPort {

    private final OrderRepositoryPort orderRepositoryPort;
    private final UserClient userClient;

    @Override
    public Order save(Order order){
        userClient.findById(order.getIdUser());
        return orderRepositoryPort.save(order);
    }

}
