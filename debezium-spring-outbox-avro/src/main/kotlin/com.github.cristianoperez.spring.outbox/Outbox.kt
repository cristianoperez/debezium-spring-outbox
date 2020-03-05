package com.github.cristianoperez.spring.outbox

import org.hibernate.annotations.Type
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "outbox")
class Outbox(
    val aggregateType: String,
    val aggregateId: String,
    @Type(type = "org.hibernate.type.BinaryType")
    val payload: ByteArray,
    val type: String
) {
    @Id
    @GeneratedValue
    val id: UUID? = null
    val timestamp: String = LocalDateTime.now(ZoneId.of("UTC")).toString()
}