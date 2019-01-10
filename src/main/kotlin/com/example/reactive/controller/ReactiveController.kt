package com.example.reactive.controller

import com.example.reactive.domain.HighlyReactive
import com.example.reactive.request.Request
import com.example.reactive.service.ReactiveService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class ReactiveController(@Autowired
                         val reactiveService: ReactiveService) {
    @GetMapping("/list")
    fun getAllData(): Flux<HighlyReactive> {
        return reactiveService.getAllReactiveData()
    }

    @PostMapping("/save")
    fun save(@RequestBody request: Mono<Request>): Mono<HighlyReactive> {
        return request
                .flatMap { it ->
                    val highlyReactive = it.somedata?.let { it1 -> HighlyReactive(it1) }
                    highlyReactive?.let { it1 -> reactiveService.save(it1) }
                }
    }
}