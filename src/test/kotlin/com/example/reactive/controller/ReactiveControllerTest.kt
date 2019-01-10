package com.example.reactive.controller

import org.junit.Test

object ReactiveControllerTest {
    @Test
    internal fun shouldRun() {
        mapOf(Pair("1","B"),Pair("2","A")).flatMap { it -> it.value.toList() }
    }
}
