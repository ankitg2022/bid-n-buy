package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.dto.BidDTO;
import com.fiftyfive.bidNBuy.dto.NotificationDTO;
import com.fiftyfive.bidNBuy.model.Bid;
import com.fiftyfive.bidNBuy.model.Notification;
import com.fiftyfive.bidNBuy.repository.BidRepository;
import com.fiftyfive.bidNBuy.repository.NotificationRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

  private final NotificationRepository notificationRepository;
  private final BidRepository bidRepository;

  public NotificationServiceImpl(NotificationRepository notificationRepository, BidRepository bidRepository) {
    this.notificationRepository = notificationRepository;
    this.bidRepository = bidRepository;
  }

  @Override
  public void create(NotificationDTO notificationDTO){
    Notification notification = new Notification(notificationDTO);
    notification.setCreationTimestamp(new Date());
    notificationRepository.save(notification);
  }

  @Override
  public List<NotificationDTO> findAllByUsername(String username) {
    List<Long> productIds = bidRepository.findMyProductIds(username);
    return notificationRepository.findAllByProductIdList(productIds).stream().map(notification -> new NotificationDTO(notification)).collect(Collectors.toList());
  }

  @Override
  public List<NotificationDTO> findAllByUsernameAndProductId(String username, Long productId) {
    return null;
  }
}