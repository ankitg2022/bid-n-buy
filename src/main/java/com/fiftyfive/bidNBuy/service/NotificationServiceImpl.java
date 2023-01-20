package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.dto.NotificationDTO;
import com.fiftyfive.bidNBuy.model.Bid;
import com.fiftyfive.bidNBuy.model.Notification;
import com.fiftyfive.bidNBuy.model.Product;
import com.fiftyfive.bidNBuy.repository.NotificationRepository;
import com.fiftyfive.bidNBuy.repository.ProductRepository;
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
  private final ProductRepository productRepository;

  @Override
  @KafkaListener(topics = "bid-events", containerFactory = "kafkaBidListenerContainerFactory", groupId = "")
  public void createBidNotification(Bid bid) {

    Notification notification = new Notification();
    Date date = new Date();
    Product product = productRepository.findById(bid.getProductId()).get();
    notification.setText(
        "A bid for product " + bid.getProductId() + " was created by user" + bid.getUsername()
            + " at " + date);
    notification.setCreationTimestamp(date);
    notification.setProductId(bid.getProductId());
    notification.setUsername(bid.getUsername());
    notificationRepository.save(notification);
    System.out.println(
        "Bid notification saved successfully with bid : " + bid + " and notification : "
            + notification);
  }

  @Override
  @KafkaListener(topics = "product-events", containerFactory = "kafkaProductListenerContainerFactory", groupId = "")
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
    return notificationRepository.findAll().stream()
        .map(notification -> new NotificationDTO(notification)).collect(Collectors.toList());
  }
}
