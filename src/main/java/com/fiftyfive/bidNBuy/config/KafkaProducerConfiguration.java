package com.fiftyfive.bidNBuy.config;

import java.util.HashMap;
import java.util.Map;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaProducerConfiguration {

  private static final int DEFAULT_MAX_BYTES = 1048576;
  private String kafkaBootstrapServer = "localhost:9092";
  private int kafkaIngestTimeoutMs = 3000;

//  @Bean
//  public ProducerFactory<String, Object> producerFactory() {
//    int maxSizeValue = DEFAULT_MAX_BYTES * 5;
//
//    Map<String, Object> config = new HashMap<>();
//    config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
//    config.put(ProducerConfig.ACKS_CONFIG, "0");
//    config.put(ProducerConfig.RETRIES_CONFIG, "0");
//    config.put(ProducerConfig.RECONNECT_BACKOFF_MAX_MS_CONFIG, 30000);
//    config.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, kafkaIngestTimeoutMs);
//    config.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, maxSizeValue);
//    config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//    config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//    return new DefaultKafkaProducerFactory<>(config);
//  }

//  @Bean
//  public KafkaTemplate<String, Object> kafkaTemplate() {
//    return new KafkaTemplate<>(producerFactory());
//  }
}
