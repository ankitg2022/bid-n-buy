package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.dto.NotificationDTO;
import com.fiftyfive.bidNBuy.model.Bid;
import com.fiftyfive.bidNBuy.model.Notification;
import com.fiftyfive.bidNBuy.repository.BidRepository;
import com.fiftyfive.bidNBuy.repository.NotificationRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {

  private final NotificationRepository notificationRepository;
  private final BidRepository bidRepository;

  @Override
  @KafkaListener(
      topics = "bid-events"
  )
  public void create(Bid bid) {

    Notification notification = new Notification();
    Date date = new Date();
    notification.setText(
        String.format("A bid for product ", bid.getProductId(), " was created at ", date));
    notification.setCreationTimestamp(date);
    notification.setProductId(bid.getProductId());
    notificationRepository.save(notification);
    System.out.println(
        "Bid notification saved successfully with bid : " + bid + " and notification : "
            + notification);
  }

  @Override
  public List<NotificationDTO> findAllByUsername(String username) {
    List<Long> productIds = bidRepository.findMyProductIds(username);
    return notificationRepository.findAllByProductIdList(productIds).stream()
        .map(notification -> new NotificationDTO(notification)).collect(Collectors.toList());
  }
}
