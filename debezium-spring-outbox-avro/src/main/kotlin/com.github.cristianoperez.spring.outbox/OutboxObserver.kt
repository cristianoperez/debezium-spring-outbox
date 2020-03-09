package com.github.cristianoperez.spring.outbox

import io.confluent.kafka.serializers.KafkaAvroSerializer
import org.springframework.boot.autoconfigure.AutoConfigurationPackage
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
@AutoConfigurationPackage
class OutboxObserver(
    private val outboxRepository: OutboxRepository,
    private val avroSerializer: KafkaAvroSerializer
) {

    @EventListener
    fun create(outboxEvent: OutboxEvent) {
        val payload = avroSerializer.serialize(outboxEvent.type, outboxEvent.payload)
        val outbox = Outbox(outboxEvent.aggregateType, outboxEvent.aggregateId, payload, outboxEvent.type)
        outboxRepository.save(outbox)
    }

}