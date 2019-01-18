package com.example.reactive.controller

import com.example.reactive.domain.Order
import com.example.reactive.domain.OrderStatus
import com.example.reactive.request.OrderRequest
import com.example.reactive.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/order")
class OrderController(@Autowired val orderService: OrderService) {

    @PostMapping("/create")
    fun createOrder(@RequestBody orderRequest: Mono<OrderRequest>): Mono<Order> {
        return orderRequest
                .flatMap { it -> orderService.createOrder(Order(it.customerName, it.orderItems, OrderStatus.PENDING)) }
    }

    @GetMapping("/status/{orderId}")
    fun orderStatus(@PathVariable(value = "orderId") orderId: String): Mono<Order> {
        return orderService.findByOrderId(orderId)
    }
}