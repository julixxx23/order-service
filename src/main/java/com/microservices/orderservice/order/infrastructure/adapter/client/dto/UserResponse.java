package com.microservices.orderservice.order.infrastructure.adapter.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long idUser;
    private String fullName;
    private String username;
    private String role;
    private Boolean isActive;
}