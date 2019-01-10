package com.example.reactive.service

import com.example.reactive.domain.HighlyReactive
import com.example.reactive.repository.ReactiveRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ReactiveService(@Autowired val reactiveRepository: ReactiveRepository) {
    fun getAllReactiveData(): Flux<HighlyReactive> {
        return reactiveRepository.findAll()
    }

    fun save(highlyReactive: HighlyReactive): Mono<HighlyReactive>{
        return reactiveRepository.save(highlyReactive)
    }
}