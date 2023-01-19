package com.fiftyfive.bidNBuy.repository;

import com.fiftyfive.bidNBuy.model.Bid;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BidRepository extends JpaRepository<Bid, Long> {

  @Query("SELECT DISTINCT(MODEL.productId) FROM Bid MODEL WHERE MODEL.username=:username")
  List<Long> findMyProductIds(@Param("username") String username);

  @Query("SELECT MODEL FROM Bid MODEL WHERE MODEL.productId=:productId")
  List<Bid> findAllByProductId(@Param("productId") Long productId);

  @Query("SELECT MAX(MODEL.bidPrice) FROM Bid MODEL WHERE MODEL.productId=:productId AND MODEL.isValid=:isValid ")
  Double findMaxBidPriceForProductId(Long productId, Boolean isValid);

  @Modifying
  @Transactional
  @Query("UPDATE Bid MODEL SET MODEL.isValid=:isValid WHERE MODEL.bidPrice<:minBidPrice AND MODEL.productId=:productId")
  void invalidateBidLessThanMinPriceForProduct(@Param("isValid") Boolean isValid,
      @Param("minBidPrice") Double minBidPrice, @Param("productId") Long productId);
}