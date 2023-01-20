package com.fiftyfive.bidNBuy.dto;

import com.fiftyfive.bidNBuy.enums.ProductCategory;
import com.fiftyfive.bidNBuy.model.Bid;
import java.util.Date;
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

  private Date creationTimestamp;
  boolean isValid;

  private ProductDTO product;

  public BidDTO(Bid object) {
    bidId = object.getBidId();
    bidPrice = object.getBidPrice();
    creationTimestamp = object.getCreationTimestamp();
    username = object.getUsername();
    isValid = object.isValid();
    productId = object.getProduct().getProductId();
  }
}
