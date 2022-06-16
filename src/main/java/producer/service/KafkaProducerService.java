package producer.service;


import io.dropwizard.lifecycle.Managed;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import producer.ProdConfig;
import producer.ProducerConfiguration;
import producer.model.Customer;

import java.util.Properties;

public class KafkaProducerService implements Managed {


    private KafkaProducer<String, Customer> producer;



    ProdConfig producerConfiguration;

    public KafkaProducerService(ProdConfig producerConfiguration) {
        this.producerConfiguration = producerConfiguration;

    }

    @Override
    public void start() {
    }

    public void sendMessageToTopic(String topic, Customer customer) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, producerConfiguration.getServers());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, producerConfiguration.getKey());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, producerConfiguration.getValue());
        this.producer = new KafkaProducer<>(props);
        ProducerRecord<String, Customer> record = new ProducerRecord<>(topic, customer);
        producer.send(record);

    }

    @Override
    public void stop() {
        this.producer.close();
    }

}
