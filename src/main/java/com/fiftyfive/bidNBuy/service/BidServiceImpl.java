package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.dto.BidDTO;
import com.fiftyfive.bidNBuy.model.Bid;
import com.fiftyfive.bidNBuy.repository.BidRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {

  private final BidRepository bidRepository;

  private final IBidIngestService bidIngestService;

  @Override
  public List<BidDTO> findAllByProductId(Long productId) {
    return bidRepository.findAllByProductId(productId).stream().map(bid -> new BidDTO(bid))
        .collect(Collectors.toList());
  }

  @Override
  public BidDTO create(BidDTO bidDTO) {
    Bid bid = new Bid(bidDTO);
    bid.setCreationTimestamp(new Date());
    bidRepository.save(bid);
    bidDTO.setBidId(bid.getBidId());
    bidIngestService.sendBid(bid);
    return bidDTO;
  }

  @Override
  public void invalidateBidLessThanMinPriceForProduct(Long productId, Double minBidPrice) {
    bidRepository.invalidateBidLessThanMinPriceForProduct(Boolean.FALSE, minBidPrice, productId);
  }
}
