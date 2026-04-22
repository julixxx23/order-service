package com.microservices.orderservice.order.domain.port.in;

import com.microservices.orderservice.order.domain.model.Order;
import com.microservices.orderservice.shared.domain.model.PageDomain;

public interface ListOrderPort {
    PageDomain<Order> list(int page, int size);

}
