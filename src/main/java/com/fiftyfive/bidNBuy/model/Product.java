package com.fiftyfive.bidNBuy.model;

import com.fiftyfive.bidNBuy.dto.ProductDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue
  private Long productId;

  private String productName;

  private String imgUrl;

  private Double minPrice;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Bid> bids;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Notification> notifications;

  public Product(ProductDTO dto) {
    productId = dto.getProductId();
    productName = dto.getProductName();
    imgUrl = dto.getImgUrl();
    minPrice = dto.getMinPrice();
  }
}
