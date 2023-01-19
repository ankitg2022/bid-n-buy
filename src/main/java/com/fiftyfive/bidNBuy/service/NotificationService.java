package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.dto.BidDTO;
import com.fiftyfive.bidNBuy.dto.NotificationDTO;
import com.fiftyfive.bidNBuy.model.Bid;
import com.fiftyfive.bidNBuy.model.Notification;
import com.fiftyfive.bidNBuy.model.Product;
import java.util.List;

public interface NotificationService {

  void createBidNotification(Bid bid);

  void createBasePriceUpdationNotification(Product product);

  List<NotificationDTO> findAllByUsername(String username);
}
