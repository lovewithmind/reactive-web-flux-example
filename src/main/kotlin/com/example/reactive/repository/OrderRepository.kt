package com.example.reactive.repository

import com.example.reactive.domain.Order
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface OrderRepository : ReactiveMongoRepository<Order,Long>{
    fun findByOrderId(orderId:String): Mono<Order>
}