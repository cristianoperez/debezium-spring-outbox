package com.github.cristianoperez.spring.outbox

import com.fasterxml.jackson.annotation.JsonIgnore

interface OutboxEvent {
    @get:JsonIgnore
    val aggregateId: String
    @get:JsonIgnore
    val aggregateType: String
}