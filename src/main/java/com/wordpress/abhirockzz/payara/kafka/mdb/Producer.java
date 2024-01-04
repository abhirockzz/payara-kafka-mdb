package com.wordpress.abhirockzz.payara.kafka.mdb;

import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.kafka.clients.producer.Callback;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class Producer implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(Producer.class.getName());

    KafkaProducer<String, String> producer;
    String topic = null;

    public Producer() {
        Properties consumerProps = new Properties();
        consumerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, System.getenv().getOrDefault("KAFKA_BROKER", "192.168.99.100:9092"));
        consumerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        consumerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(consumerProps);
        topic = System.getenv().getOrDefault("TOPIC_NAME", "test-topic");
    }

    static Random rnd = new Random();

    @Override
    public void run() {
        LOGGER.log(Level.INFO, "Producing to topic " + topic);
        while (true) {
            producer.send(new ProducerRecord(topic, "key-" + rnd.nextInt(10), "val-" + rnd.nextInt(10)), (rm, excptn) -> LOGGER.log(Level.INFO, "Sent data...."));
            try {
                Thread.sleep(10000); //take it easy!
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
