package com.microservices.orderservice.order.domain.port.in;

import com.microservices.orderservice.order.domain.model.Order;

public interface FindByIdOrderPort {
    Order findById(Long id);
}
