package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.model.Bid;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import lombok.RequiredArgsConstructor;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BidIngestServiceImpl implements IBidIngestService {

//  private final KafkaTemplate<String, Object> kafkaTemplate;

  private final String topic = "bid-events";

  private int kafkaIngestTimeoutMs = 3000;

  @Override
  public void sendBid(Bid bid) {
//    final var future = kafkaTemplate.send(topic, null, bid);

//    try {
//      future.get(kafkaIngestTimeoutMs, TimeUnit.MILLISECONDS);
//    } catch (ExecutionException | InterruptedException | TimeoutException e) {
//      throw new RuntimeException(e);
//    }
  }
}
