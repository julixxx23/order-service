package com.microservices.orderservice.order.infrastructure.config;

import com.microservices.orderservice.order.application.FindByOrderUseCase;
import com.microservices.orderservice.order.application.OrderListUseCase;
import com.microservices.orderservice.order.application.OrderSaveUseCase;
import com.microservices.orderservice.order.domain.port.in.FindByIdOrderPort;
import com.microservices.orderservice.order.domain.port.in.ListOrderPort;
import com.microservices.orderservice.order.domain.port.in.SaveOrderPort;
import com.microservices.orderservice.order.domain.port.out.OrderRepositoryPort;
import com.microservices.orderservice.order.infrastructure.adapter.client.UserClient;
import com.microservices.orderservice.order.infrastructure.adapter.out.persistence.OrderJpaAdapter;
import com.microservices.orderservice.order.infrastructure.adapter.out.persistence.mapper.OrderPersistenceMapper;
import com.microservices.orderservice.order.infrastructure.adapter.out.persistence.repository.OrderJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderBeanConfig {

    @Bean
    public OrderRepositoryPort orderRepositoryPort(
            OrderJpaRepository jpaRepository,
            OrderPersistenceMapper mapper){
        return new OrderJpaAdapter(jpaRepository, mapper);
    }

    @Bean
    public SaveOrderPort saveOrderPort(OrderRepositoryPort orderRepositoryPort, UserClient userClient){
        return new OrderSaveUseCase(orderRepositoryPort, userClient);
    }

    @Bean
    public ListOrderPort listOrderPort(OrderRepositoryPort orderRepositoryPort){
        return new OrderListUseCase(orderRepositoryPort);
    }

    @Bean
    public FindByIdOrderPort findByIdOrderPort(OrderRepositoryPort orderRepositoryPort){
        return new FindByOrderUseCase(orderRepositoryPort);
    }


}
