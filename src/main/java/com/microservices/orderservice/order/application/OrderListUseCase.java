package com.microservices.orderservice.order.application;

import com.microservices.orderservice.order.domain.model.Order;
import com.microservices.orderservice.order.domain.port.in.ListOrderPort;
import com.microservices.orderservice.order.domain.port.out.OrderRepositoryPort;
import com.microservices.orderservice.shared.domain.model.PageDomain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderListUseCase implements ListOrderPort {
    private final OrderRepositoryPort orderRepositoryPort;

    @Override
    public PageDomain<Order> list(int page, int size){
        return orderRepositoryPort.list(page, size);
    }
}
