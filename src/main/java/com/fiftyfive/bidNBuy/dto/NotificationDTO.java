package com.fiftyfive.bidNBuy.dto;

import com.fiftyfive.bidNBuy.model.Notification;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotificationDTO {

  private Long notificationId;

  private String text;

  private String username;

  private Date creationTimestamp;

  private Long productId;

  public NotificationDTO(Notification object) {
    this.notificationId = object.getNotificationId();
    this.text = object.getText();
    this.username = object.getUsername();
    this.creationTimestamp = object.getCreationTimestamp();
    this.productId = object.getProductId();
  }
}