package com.github.cristianoperez.spring.outbox

import org.apache.avro.specific.SpecificRecord

interface OutboxEvent {
    val aggregateId: String
    val aggregateType: String
    val payload: SpecificRecord
    val type: String
        get() = payload.schema.name
}