package com.fiftyfive.bidNBuy.model;

import com.fiftyfive.bidNBuy.dto.NotificationDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Notification {

  @Id
  @GeneratedValue
  private Long notificationId;

  private String text;

  private Date creationTimestamp;

  private Long productId;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "productId", referencedColumnName = "productId", insertable = false, updatable = false)
  private Product product;

  public Notification(NotificationDTO object) {
    notificationId = object.getNotificationId();
    text = object.getText();
    productId = object.getProductId();
  }
}