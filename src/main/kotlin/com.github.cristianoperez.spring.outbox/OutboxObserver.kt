package com.github.cristianoperez.spring.outbox

import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class OutboxObserver(
    private val outboxRepository: OutboxRepository
) {

    @EventListener
    fun create(outboxEvent: OutboxEvent) {
        val outbox = Outbox(outboxEvent.aggregateType, outboxEvent.aggregateId, outboxEvent)
        outboxRepository.save(outbox)
    }
}