package com.wordpress.abhirockzz.payara.kafka.mdb;

import fish.payara.cloud.connectors.kafka.api.KafkaListener;
import fish.payara.cloud.connectors.kafka.api.OnRecord;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.logging.Level;
import java.util.logging.Logger;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "testClient"),
    @ActivationConfigProperty(propertyName = "groupIdConfig", propertyValue = "testGroup"),
    @ActivationConfigProperty(propertyName = "topics", propertyValue = "${ENV=TOPIC_NAME}"),
    @ActivationConfigProperty(propertyName = "bootstrapServersConfig", propertyValue = "${ENV=KAFKA_BROKER}"),
    @ActivationConfigProperty(propertyName = "autoCommitInterval", propertyValue = "100"),
    @ActivationConfigProperty(propertyName = "retryBackoff", propertyValue = "1000"),
    @ActivationConfigProperty(propertyName = "keyDeserializer", propertyValue = "org.apache.kafka.common.serialization.StringDeserializer"),
    @ActivationConfigProperty(propertyName = "valueDeserializer", propertyValue = "org.apache.kafka.common.serialization.StringDeserializer"),
    @ActivationConfigProperty(propertyName = "pollInterval", propertyValue = "30000"),
})
public class KafkaMDB implements KafkaListener {

    private static final Logger LOGGER = Logger.getLogger(KafkaMDB.class.getName());

    public KafkaMDB() {
    }

    @OnRecord( topics={"payara-kafka-mdb-topic"})
    public void consume(ConsumerRecord<Object,Object> record) {
        LOGGER.log(Level.INFO, "Payara Kafka MDB record key={0} and value: {1}", new Object[]{record.key(), record.value()});
    }
}
