package fr.nullpointer.consulting;

/*import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.TopicDescription;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.Properties;
import java.util.Random;
import java.io.IOException;

public class Producer
{
    public static void produce(String brokers, String topicName) throws IOException
    {

        // Set properties used to configure the producer
        Properties properties = new Properties();
        // Set the brokers (bootstrap servers)
        properties.setProperty("bootstrap.servers", brokers);
        // Set how to serialize key/value pairs
        properties.setProperty("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        // specify the protocol for Domain Joined clusters
        //properties.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // So we can generate random sentences
        Random random = new Random();
        String[] sentences = new String[] {
                "the cow jumped over the moon",
                "an apple a day keeps the doctor away",
                "four score and seven years ago",
                "snow white and the seven dwarfs",
                "i am at two with nature"
        };

        String progressAnimation = "|/-\\";
        // Produce a bunch of records
        for(int i = 0; i < 100; i++) {
            // Pick a sentence at random
            String sentence = sentences[random.nextInt(sentences.length)];
            // Send the sentence to the test topic
            try
            {
                producer.send(new ProducerRecord<String, String>(topicName, sentence)).get();
            }
            catch (Exception ex)
            {
                System.out.print(ex.getMessage());
                throw new IOException(ex.toString());
            }
            String progressBar = "\r" + progressAnimation.charAt(i % progressAnimation.length()) + " " + i;
            System.out.write(progressBar.getBytes());
        }
    }*/

import java.util.*; //utilise toutes les classes du pack java.util
import org.apache.kafka.clients.producer.*;

public class SimpleProducer {

    public void createMessage() {

        String topicName = "nasa"; //nom du topic créer sur le serveur kafka
        String key = "Key1"; //clé usitilé par kafka pour identifier de maniere unique le message
        String value = "Hello World"; //message a transmettre au serveur kafka

        Properties props = new Properties();
        props.put("bootstrap.servers", "34.73.213.133:2181");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, value);
        producer.send(record,
                new Callback() {
                    public void onCompletion(RecordMetadata metadata, Exception e) {
                        if(e != null) {
                            e.printStackTrace();
                        } else {
                            System.out.println("The offset of the record we just sent is: " + metadata.offset());
                        }
                    }
                });
        producer.flush();
        producer.close();

        System.out.println("SimpleProducer Completed.");
    }
}