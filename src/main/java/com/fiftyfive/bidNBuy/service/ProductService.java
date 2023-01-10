package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.dto.ProductDTO;
import java.util.List;

public interface ProductService {

  void create(ProductDTO dto);
  List<ProductDTO> findAll();

  ProductDTO findById(Long productId);

  void setMinimumPrice(Long productId, Double minPrice);
}
