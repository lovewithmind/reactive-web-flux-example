package com.example.reactive.repository

import com.example.reactive.domain.HighlyReactive
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ReactiveRepository : ReactiveMongoRepository<HighlyReactive, Long>