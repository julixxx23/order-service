package com.microservices.orderservice.order.infrastructure.adapter.out.persistence.repository;

import com.microservices.orderservice.order.infrastructure.adapter.out.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {



}
