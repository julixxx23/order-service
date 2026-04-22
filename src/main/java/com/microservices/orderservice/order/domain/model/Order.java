package com.microservices.orderservice.order.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long idOrder;
    private Long idUser;
    private String details;
    private LocalDateTime createdAt;
}
