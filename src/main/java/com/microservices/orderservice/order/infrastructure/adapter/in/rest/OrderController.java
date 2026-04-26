package com.microservices.orderservice.order.infrastructure.adapter.in.rest;

import com.microservices.orderservice.order.domain.model.Order;
import com.microservices.orderservice.order.domain.port.in.FindByIdOrderPort;
import com.microservices.orderservice.order.domain.port.in.ListOrderPort;
import com.microservices.orderservice.order.domain.port.in.SaveOrderPort;
import com.microservices.orderservice.order.infrastructure.adapter.in.rest.dto.OrderCreateRequest;
import com.microservices.orderservice.order.infrastructure.adapter.in.rest.dto.OrderResponse;
import com.microservices.orderservice.order.infrastructure.adapter.in.rest.mapper.OrderRestMapper;
import com.microservices.orderservice.shared.domain.model.PageDomain;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final SaveOrderPort saveOrderPort;
    private final ListOrderPort listOrderPort;
    private final FindByIdOrderPort findByIdOrderPort;
    private final OrderRestMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long id){
        Order order = findByIdOrderPort.findById(id);
        return ResponseEntity.ok(mapper.toResponse(order));
    }

    @GetMapping
    public ResponseEntity<PageDomain<OrderResponse>> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        PageDomain<Order> pages = listOrderPort.list(page, size);
        PageDomain<OrderResponse> pageDomain = new PageDomain<>(
                pages.content().stream().map(mapper::toResponse).toList(),
                pages.currentPage(),
                pages.totalPages(),
                pages.totalElements()
        );
        return ResponseEntity.ok(pageDomain);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> save(@Valid @RequestBody OrderCreateRequest request){
        Order order = saveOrderPort.save(mapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(order));
    }




}
