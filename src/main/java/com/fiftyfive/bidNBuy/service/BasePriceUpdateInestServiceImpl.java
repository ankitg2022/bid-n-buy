package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.model.Bid;
import com.fiftyfive.bidNBuy.model.Product;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasePriceUpdateInestServiceImpl implements IBasePriceUpdateIngestService{

  private final KafkaTemplate<String, Object> kafkaTemplate;

  private final String topic = "product-events";

  private int kafkaIngestTimeoutMs = 3000;


  @Override
  public void sendBasePriceUpdate(Product product) {
    final var future = kafkaTemplate.send(topic, null, product);

    try {
      future.get(kafkaIngestTimeoutMs, TimeUnit.MILLISECONDS);
    } catch (ExecutionException | InterruptedException | TimeoutException e) {
      throw new RuntimeException(e);
    }
  }
}
