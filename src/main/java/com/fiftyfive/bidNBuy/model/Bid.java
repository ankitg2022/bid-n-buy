package com.fiftyfive.bidNBuy.model;

import com.fiftyfive.bidNBuy.dto.BidDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Bid {

  @Id
  @GeneratedValue
  private Long bidId;

  private Double bidPrice;

  private String username;

  boolean isValid;

  private Long productId;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "productId", referencedColumnName = "productId", insertable = false, updatable = false)
  private Product product;

  public Bid(BidDTO object) {
    bidId = object.getProductId();
    bidPrice = object.getBidPrice();
    username = object.getUsername();
    isValid = object.isValid();
    productId = object.getProductId();
  }
}
