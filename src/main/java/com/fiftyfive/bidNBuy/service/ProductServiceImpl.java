package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.dto.ProductDTO;
import com.fiftyfive.bidNBuy.enums.ProductCategory;
import com.fiftyfive.bidNBuy.exceptions.ResourceNotFoundException;
import com.fiftyfive.bidNBuy.model.Product;
import com.fiftyfive.bidNBuy.repository.BidRepository;
import com.fiftyfive.bidNBuy.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  private final BidRepository bidRepository;

  private final IBasePriceUpdateIngestService basePriceUpdateIngestService;

  @Override
  public void create(ProductDTO dto) {
    productRepository.save(new Product(dto));
  }

  @Override
  public List<ProductDTO> findAllInCategory(ProductCategory category) {
    Double maxBid;
    List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
    for (Product product : productRepository.findAllByCategory(category)) {
      maxBid = bidRepository.findMaxBidPriceForProductId(product.getProductId(), Boolean.TRUE);
      productDTOList.add(new ProductDTO(product, maxBid,
          bidRepository.findAllByProductId(product.getProductId()).size()));
    }
    return productDTOList;
  }

  @Override
  public ProductDTO findById(Long productId) {
    return new ProductDTO(
        productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product", String.valueOf(productId))),
        0.0, 0);
  }

  @Override
  public void setMinimumPrice(Long productId, Double minPrice) {
    productRepository.updateMinPrice(minPrice, productId);

    Product product = productRepository.findById(productId).get();
    basePriceUpdateIngestService.sendBasePriceUpdateEvent(product);
  }
}