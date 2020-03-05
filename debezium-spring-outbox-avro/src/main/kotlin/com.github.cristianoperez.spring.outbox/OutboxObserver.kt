package com.github.cristianoperez.spring.outbox

import org.springframework.boot.autoconfigure.AutoConfigurationPackage
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
@AutoConfigurationPackage
class OutboxObserver(
    private val outboxRepository: OutboxRepository,
    private val avroSerializer: AvroSerializer
) {

    @EventListener
    fun create(outboxEvent: OutboxEvent) {
        val avroSerializer = avroSerializer.avroSerializer()
        val payload = avroSerializer.serialize(outboxEvent.type, outboxEvent.payload)
        val outbox = Outbox(outboxEvent.aggregateType, outboxEvent.aggregateId, payload, outboxEvent.type)
        outboxRepository.save(outbox)
    }

}