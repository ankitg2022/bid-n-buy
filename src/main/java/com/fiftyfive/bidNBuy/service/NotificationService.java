package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.dto.BidDTO;
import com.fiftyfive.bidNBuy.dto.NotificationDTO;
import com.fiftyfive.bidNBuy.model.Bid;
import com.fiftyfive.bidNBuy.model.Notification;
import java.util.List;

public interface NotificationService {

  void create(Bid bid);

  List<NotificationDTO> findAllByUsername(String username);
}
