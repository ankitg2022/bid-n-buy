package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.dto.BidDTO;
import com.fiftyfive.bidNBuy.dto.ProductDTO;
import com.fiftyfive.bidNBuy.model.Bid;
import com.fiftyfive.bidNBuy.repository.BidRepository;
import com.fiftyfive.bidNBuy.repository.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImpl implements BidService {

  private final BidRepository bidRepository;

  public BidServiceImpl(BidRepository bidRepository) {
    this.bidRepository = bidRepository;
  }

  @Override
  public List<BidDTO> findAllByProductId(Long productId) {
    return bidRepository.findAllByProductId(productId).stream().map(bid -> new BidDTO(bid)).collect(Collectors.toList());
  }

  @Override
  public BidDTO create(BidDTO bidDTO) {
    Bid bid = new Bid(bidDTO);
    bidRepository.save(bid);
    bidDTO.setBidId(bid.getBidId());
    return bidDTO;
  }

  @Override
  public void invalidateBidLessThanMinPriceForProduct(Long productId, Double minBidPrice) {
    bidRepository.invalidateBidLessThanMinPriceForProduct(Boolean.FALSE, minBidPrice, productId);
  }
}