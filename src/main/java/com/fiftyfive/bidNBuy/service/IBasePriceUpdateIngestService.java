package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.model.Bid;
import com.fiftyfive.bidNBuy.model.Product;

public interface IBasePriceUpdateIngestService {
  void sendBasePriceUpdateEvent(Product product);
}
