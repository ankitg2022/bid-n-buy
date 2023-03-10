package com.fiftyfive.bidNBuy.repository;

import com.fiftyfive.bidNBuy.enums.ProductCategory;
import com.fiftyfive.bidNBuy.model.Product;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findAllByCategory(ProductCategory category);
  @Modifying
  @Transactional
  @Query("UPDATE Product MODEL SET MODEL.minPrice=:minPrice WHERE MODEL.productId=:productId")
  void updateMinPrice(@Param("minPrice") Double minPrice, @Param("productId") Long productId);
}