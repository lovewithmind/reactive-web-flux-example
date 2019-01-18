package com.example.reactive.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.annotation.Generated

@Document(collection = "order")
data class Order(val customerName: String?, val OrderItems: List<String>?, val orderStatus: OrderStatus) {

    @Id
    @Generated
    var orderId: String? = null
}