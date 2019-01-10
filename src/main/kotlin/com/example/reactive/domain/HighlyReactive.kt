package com.example.reactive.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.annotation.Generated

@Document(collection = "reactive")
data class HighlyReactive(var somedata: String) {
    @Id
    @Generated
    var id: String? = null
}