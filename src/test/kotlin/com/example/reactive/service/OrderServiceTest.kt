package com.example.reactive.service

import com.example.reactive.domain.Order
import com.example.reactive.domain.OrderStatus
import io.kotlintest.shouldBe
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import reactor.test.StepVerifier

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceTest {
    @Autowired
    lateinit var orderService: OrderService

    @Test
    fun `should save order in repository`() {
        val actualOrder = orderService.createOrder(Order("somename", listOf("item1", "item2"),OrderStatus.PENDING)).block()

        StepVerifier
                .create(orderService.findByOrderId(actualOrder.orderId!!))
                .assertNext { expectedOrder ->
                    expectedOrder.orderId shouldBe actualOrder.orderId
                    expectedOrder.customerName shouldBe actualOrder.customerName
                    expectedOrder.OrderItems shouldBe actualOrder.OrderItems
                }
                .verifyComplete()
    }
}