package com.github.cristianoperez.spring.outbox

import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "outbox")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
class Outbox(
    private val aggregateType: String,
    private val aggregateId: String,
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private val payload: OutboxEvent
) {
    @Id
    @GeneratedValue
    private val id: UUID? = null
    private val timestamp: String = LocalDateTime.now().toString()
    private val type: String = payload.javaClass.simpleName.replace("Event.*".toRegex(), "")
}