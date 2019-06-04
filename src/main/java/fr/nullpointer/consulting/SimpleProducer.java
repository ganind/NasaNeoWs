package fr.nullpointer.consulting;


import java.util.*; //utilise toutes les classes du pack java.util
import org.apache.kafka.clients.producer.*;

public class SimpleProducer {

    public void createMessage(String donnees) {

        String topicName = "nasa"; //nom du topic créer sur le serveur kafka
        String key = "Key1"; //clé usitilé par kafka pour identifier de maniere unique le message

        Properties props = new Properties();
        props.put("bootstrap.servers", "34.73.26.106:9092");
        props.put("client.id", "1");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, donnees);
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