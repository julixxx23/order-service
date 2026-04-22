package com.microservices.orderservice.order.infrastructure.adapter.out.persistence;

import com.microservices.orderservice.order.domain.model.Order;
import com.microservices.orderservice.order.domain.port.out.OrderRepositoryPort;
import com.microservices.orderservice.order.infrastructure.adapter.out.persistence.entity.OrderEntity;
import com.microservices.orderservice.order.infrastructure.adapter.out.persistence.mapper.OrderPersistenceMapper;
import com.microservices.orderservice.order.infrastructure.adapter.out.persistence.repository.OrderJpaRepository;
import com.microservices.orderservice.shared.domain.model.PageDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@RequiredArgsConstructor
public class OrderJpaAdapter implements OrderRepositoryPort {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderPersistenceMapper mapper;

    @Override
    public Order save(Order order){
        return mapper.toDomain(orderJpaRepository.save(mapper.toEntity(order)));
    }

    @Override
    public Optional<Order> findById(Long id){
        return orderJpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public PageDomain<Order> list(int page, int size){
        Page<OrderEntity> pageEntity = orderJpaRepository.findAll(PageRequest.of(page, size));
        Page<Order> pages = pageEntity.map(mapper::toDomain);

        return new PageDomain<>(
                pages.getContent(),
                pages.getNumber(),
                pages.getTotalPages(),
                pages.getTotalElements()
        );
    }
}
