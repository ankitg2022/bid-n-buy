package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.dto.ProductDTO;
import com.fiftyfive.bidNBuy.enums.ProductCategory;
import java.util.List;

public interface ProductService {

  void create(ProductDTO dto);
  List<ProductDTO> findAllInCategory(ProductCategory category);

  ProductDTO findById(Long productId);

  void setMinimumPrice(Long productId, Double minPrice);
}
