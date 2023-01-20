package com.fiftyfive.bidNBuy.model;

import com.fiftyfive.bidNBuy.dto.ProductDTO;
import com.fiftyfive.bidNBuy.enums.ProductCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
  @Enumerated(EnumType.STRING)
  private ProductCategory category;

  public Product(ProductDTO dto) {
    productId = dto.getProductId();
    productName = dto.getProductName();
    imgUrl = dto.getImgUrl();
    minPrice = dto.getMinPrice();
    category = dto.getCategory();
  }
}
