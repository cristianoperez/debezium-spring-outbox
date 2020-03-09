import java.net.URI

repositories {
    maven { url = URI("http://packages.confluent.io/maven/") }
}
dependencies {
    api("org.apache.avro:avro:1.9.0")
    api("io.confluent:kafka-avro-serializer:5.3.2")
    implementation("org.apache.kafka:kafka_2.13:2.4.0")
}