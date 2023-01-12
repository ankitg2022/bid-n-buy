package com.fiftyfive.bidNBuy.dto;

import com.fiftyfive.bidNBuy.enums.ProductCategory;
import com.fiftyfive.bidNBuy.model.Product;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

  private Long productId;

  private String productName;

  private String imgUrl;

  private Double minPrice;

  private ProductCategory category;

  private List<BidDTO> bids;

  private List<NotificationDTO> notifications;

  public ProductDTO(Product object) {
    productId = object.getProductId();
    productName = object.getProductName();
    imgUrl = object.getImgUrl();
    minPrice = object.getMinPrice();
    category = object.getCategory();
  }
}