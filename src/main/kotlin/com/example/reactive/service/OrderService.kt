package com.example.reactive.service

import com.example.reactive.domain.Order
import com.example.reactive.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
open class OrderService(@Autowired val orderRepository: OrderRepository) {
    open fun createOrder(order: Order): Mono<Order> {
        return orderRepository.save(order)
    }

    open fun findByOrderId(orderId: String): Mono<Order> {
        return orderRepository.findByOrderId(orderId)
    }
}