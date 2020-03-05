package com.github.cristianoperez.spring.outbox

import org.apache.avro.specific.SpecificRecord
import org.apache.avro.specific.SpecificRecordBase
import org.springframework.context.ApplicationEventPublisher
import java.util.*

fun ApplicationEventPublisher.publish(record: SpecificRecord, aggregateId: UUID, aggregateType: String) {
    val outboxEvent = object : OutboxEvent {
        override val aggregateId = aggregateId.toString()
        override val aggregateType = aggregateType
        override val payload = record
    }
    this.publishEvent(outboxEvent)
}