package com.microservices.orderservice.order.infrastructure.adapter.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private Long idOrder;
    private Long idUser;
    private String details;
    private LocalDateTime createdAt;
}
