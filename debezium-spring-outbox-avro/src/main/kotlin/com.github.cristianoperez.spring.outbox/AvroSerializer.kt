package com.github.cristianoperez.spring.outbox

import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient
import io.confluent.kafka.serializers.KafkaAvroSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class AvroSerializer(
    @Value("\${outbox.schema.registry.url:http://localhost:8081}") val schemaRegistryUrl: String,
    @Value("\${outbox.schema.registru.identity.capacity:1000}") val identityMapCapacity: Int
) {

    @Bean
    fun avroSerializer(): KafkaAvroSerializer {
        val schemaRegistryClient = CachedSchemaRegistryClient(schemaRegistryUrl, identityMapCapacity)
        return KafkaAvroSerializer(schemaRegistryClient)
    }

}
