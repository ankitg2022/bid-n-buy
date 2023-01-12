package com.fiftyfive.bidNBuy.dto;

import com.fiftyfive.bidNBuy.model.Notification;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotificationDTO {

  private Long notificationId;

  private String text;

  private Long productId;

  public NotificationDTO(Notification object) {
    notificationId = object.getNotificationId();
    text = object.getText();
    productId = object.getProductId();
  }
}