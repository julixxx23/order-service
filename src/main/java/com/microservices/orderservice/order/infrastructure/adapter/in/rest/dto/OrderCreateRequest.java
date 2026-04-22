package com.microservices.orderservice.order.infrastructure.adapter.in.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequest {

    @NotBlank(message = "The details obligatory")
    @Size(max = 500, message = "Details must not exceed 500 characters")
    private String details;
}
