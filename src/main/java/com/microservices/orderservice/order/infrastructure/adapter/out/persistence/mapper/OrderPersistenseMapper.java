package com.microservices.orderservice.order.infrastructure.adapter.out.persistence.mapper;

import com.microservices.orderservice.order.domain.model.Order;
import com.microservices.orderservice.order.infrastructure.adapter.out.persistence.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderPersistenseMapper {

    public Order toDomain(OrderEntity entity){
        return Order.builder()
                .idOrder(entity.getIdOrder())
                .idUser(entity.getIdUser())
                .details(entity.getDetails())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public OrderEntity toEntity(Order order){
        OrderEntity entity = new OrderEntity();
        entity.setIdOrder(order.getIdOrder());
        entity.setIdUser(order.getIdUser());
        entity.setDetails(order.getDetails());
        entity.setCreatedAt(order.getCreatedAt());
        return entity;

    }
}
