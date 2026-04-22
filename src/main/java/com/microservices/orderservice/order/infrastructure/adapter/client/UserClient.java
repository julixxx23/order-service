package com.microservices.orderservice.order.infrastructure.adapter.client;

import com.microservices.orderservice.order.infrastructure.adapter.client.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/api/v1/user/{id}")
    UserResponse findById(@PathVariable Long id);
}