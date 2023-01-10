package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.dto.BidDTO;
import com.fiftyfive.bidNBuy.dto.NotificationDTO;
import java.util.List;

public interface NotificationService {

  List<NotificationDTO> findAllByUsername(String username);

  List<NotificationDTO> findAllByUsernameAndProductId(String username, Long productId);
}
