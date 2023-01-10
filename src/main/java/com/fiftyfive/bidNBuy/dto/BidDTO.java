package com.fiftyfive.bidNBuy.dto;

import com.fiftyfive.bidNBuy.model.Bid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BidDTO {

  private Long bidId;

  private Double bidPrice;

  private String username;

  private Long productId;

  boolean isValid;

  private ProductDTO product;

  public BidDTO(Bid object) {
    bidId = object.getProductId();
    bidPrice = object.getBidPrice();
    username = object.getUsername();
    isValid = object.isValid();
    productId = object.getProductId();
  }
}
