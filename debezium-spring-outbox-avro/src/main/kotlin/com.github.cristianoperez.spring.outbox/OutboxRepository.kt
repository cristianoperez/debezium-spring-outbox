package com.github.cristianoperez.spring.outbox

import org.springframework.data.repository.Repository
import java.util.*

interface OutboxRepository : Repository<Outbox, UUID> {
    fun save(outbox: Outbox): Outbox
}