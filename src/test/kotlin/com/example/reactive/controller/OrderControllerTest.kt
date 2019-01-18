package com.example.reactive.controller

import com.example.reactive.request.OrderRequest
import com.google.gson.Gson
import io.kotlintest.should
import io.kotlintest.shouldBe
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun `should create new order`() {
        val itemList = listOf("Fan", "Washing Machine")
        val customerName = "SomeCustomer"
        val orderRequest = OrderRequest(customerName, itemList)

        webTestClient
                .post()
                .uri("/order/create")
                .body(BodyInserters.fromObject(orderRequest))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().is2xxSuccessful
                .expectBody()
                .should { it ->
                    String(it.returnResult().requestBodyContent) shouldBe Gson().toJson(orderRequest)
                }
    }
}