package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.dto.NotificationDTO;
import com.fiftyfive.bidNBuy.model.Bid;
import com.fiftyfive.bidNBuy.model.Notification;
import com.fiftyfive.bidNBuy.model.Product;
import com.fiftyfive.bidNBuy.repository.BidRepository;
import com.fiftyfive.bidNBuy.repository.NotificationRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {

  private final NotificationRepository notificationRepository;
  private final BidRepository bidRepository;

  @Override
  @KafkaListener(topics = "bid-events")
  public void createBidNotification(Bid bid) {

    Notification notification = new Notification();
    Date date = new Date();
    notification.setText(
        "A bid for product id : " + bid.getProduct().getProductId() + " name : " + bid.getProduct()
            .getProductName() + " was created at " + date);
    notification.setCreationTimestamp(date);
    notification.setProductId(bid.getProduct().getProductId());
    notificationRepository.save(notification);
    System.out.println(
        "Bid notification saved successfully with bid : " + bid + " and notification : "
            + notification);
  }

  @Override
  @KafkaListener(topics = "product-events")
  public void createBasePriceUpdationNotification(Product product) {
    Notification notification = new Notification();
    Date date = new Date();
    notification.setText("Base price for product id : " + product.getProductId() + " with name "
        + product.getProductName() + " has been changed by the seller at " + date);
    notification.setCreationTimestamp(date);
    notification.setProductId(product.getProductId());
    notificationRepository.save(notification);
    System.out.println(
        "Base price for product " + product.getProductId() + " has been changed by the seller at "
            + date + " and notification has been saved successfully: " + notification);
  }

  @Override
  public List<NotificationDTO> findAllByUsername(String username) {

    return new ArrayList<NotificationDTO>();

//    List<Long> productIds = bidRepository.findMyProductIds(username);
//    return notificationRepository.findAllByProductIdList(productIds).stream()
//        .map(notification -> new NotificationDTO(notification)).collect(Collectors.toList());
  }
}
