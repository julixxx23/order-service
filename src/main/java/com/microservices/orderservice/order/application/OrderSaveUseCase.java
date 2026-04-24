package com.microservices.orderservice.order.application;

import com.microservices.orderservice.order.domain.exception.UserNotFoundException;
import com.microservices.orderservice.order.domain.model.Order;
import com.microservices.orderservice.order.domain.port.in.SaveOrderPort;
import com.microservices.orderservice.order.domain.port.out.OrderRepositoryPort;
import com.microservices.orderservice.order.infrastructure.adapter.client.UserClient;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.ws.rs.ServiceUnavailableException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderSaveUseCase implements SaveOrderPort {

    private final OrderRepositoryPort orderRepositoryPort;
    private final UserClient userClient;

    @Override
    @CircuitBreaker(name = "user-service", fallbackMethod = "fallbackSave")
    public Order save(Order order) {
        try {
            userClient.findById(order.getIdUser());
        } catch (FeignException.NotFound e) {
            throw new UserNotFoundException("User not found with id: " + order.getIdUser());
        }
        return orderRepositoryPort.save(order);
    }

    public Order fallbackSave(Order order, Exception e) {
        throw new ServiceUnavailableException("User service is unavailable, try again later");
    }
}
