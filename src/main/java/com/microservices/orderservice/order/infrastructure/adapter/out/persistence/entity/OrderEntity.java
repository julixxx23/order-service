package com.microservices.orderservice.order.infrastructure.adapter.out.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long idOrder;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "details")
    private String details;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
