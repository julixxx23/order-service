package com.microservices.orderservice.order.domain.port.in;

import com.microservices.orderservice.order.domain.model.Order;

public interface SaveOrderPort {
    Order save(Order order);
}
