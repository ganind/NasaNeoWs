package fr.nullpointer.consulting;

import java.util.*;
import java.io.*;
import java.util.function.Supplier;
//import java.util.function.Supplier;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class ManualConsumer {
/*
    public static void main(String[] args) throws Exception {

        String topicName = "SupplierTopic";
        String groupName = "SupplierTopicGroup";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093");
        props.put("group.id", groupName);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "SupplierDeserializer");
        props.put("enable.auto.commit", "false");

        KafkaConsumer<String, Supplier> consumer = null;

        try {
            consumer = new KafkaConsumer<>(props);
            consumer.subscribe(Arrays.asList(topicName));

            while (true) {
                ConsumerRecords<String, Supplier> records = consumer.poll(100);
                for (ConsumerRecord<String, Supplier> record : records) {
                    System.out.println("Supplier id= " + String.valueOf(record.value());
                }
                consumer.commitAsync();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            consumer.commitSync();
            consumer.close();
        }
    }
*/
}
