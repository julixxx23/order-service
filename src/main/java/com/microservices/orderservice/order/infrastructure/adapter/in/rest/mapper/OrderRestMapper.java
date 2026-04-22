package com.microservices.orderservice.order.infrastructure.adapter.in.rest.mapper;

import com.microservices.orderservice.order.domain.model.Order;
import com.microservices.orderservice.order.infrastructure.adapter.in.rest.dto.OrderCreateRequest;
import com.microservices.orderservice.order.infrastructure.adapter.in.rest.dto.OrderResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderRestMapper {

    public Order toDomain(OrderCreateRequest request){
        return Order.builder()
                .details(request.getDetails())
                .build();
    }

    public OrderResponse toResponse(Order order){
        return OrderResponse.builder()
                .idOrder(order.getIdOrder())
                .idUser(order.getIdUser())
                .details(order.getDetails())
                .createdAt(order.getCreatedAt())
                .build();
    }

}
