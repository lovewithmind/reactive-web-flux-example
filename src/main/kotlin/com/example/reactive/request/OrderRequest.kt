package com.example.reactive.request

data class OrderRequest(val customerName: String? = null ,val orderItems: List<String>? = null)
