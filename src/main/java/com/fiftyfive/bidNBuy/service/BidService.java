package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.dto.BidDTO;
import com.fiftyfive.bidNBuy.dto.ProductDTO;
import java.util.List;

public interface BidService {

  List<BidDTO> findAllByProductId(Long productId);

  BidDTO create(BidDTO bidDTO);

  void invalidateBidLessThanMinPriceForProduct(Long productId, Double minBidPrice);
}
