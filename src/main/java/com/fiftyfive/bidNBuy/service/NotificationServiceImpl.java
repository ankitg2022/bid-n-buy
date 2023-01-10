package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.dto.BidDTO;
import com.fiftyfive.bidNBuy.dto.NotificationDTO;
import com.fiftyfive.bidNBuy.model.Bid;
import com.fiftyfive.bidNBuy.repository.BidRepository;
import com.fiftyfive.bidNBuy.repository.NotificationRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

  private final NotificationRepository notificationRepository;

  public NotificationServiceImpl(NotificationRepository notificationRepository) {
    this.notificationRepository = notificationRepository;
  }

  @Override
  public List<NotificationDTO> findAllByUsername(String username) {
    return null;
  }

  @Override
  public List<NotificationDTO> findAllByUsernameAndProductId(String username, Long productId) {
    return null;
  }
}