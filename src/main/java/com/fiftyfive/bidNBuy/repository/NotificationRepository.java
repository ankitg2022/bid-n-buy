package com.fiftyfive.bidNBuy.repository;

import com.fiftyfive.bidNBuy.model.Notification;
import com.fiftyfive.bidNBuy.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

  @Query("SELECT MODEL FROM Notification MODEL WHERE MODEL.productId IN :productIdList GROUP BY MODEL.productId")
  List<Notification> findAllByProductIdList(@Param("productIdList") List<Long> productIdList);
}