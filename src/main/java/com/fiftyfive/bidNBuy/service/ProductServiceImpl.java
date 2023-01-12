package com.fiftyfive.bidNBuy.service;

import com.fiftyfive.bidNBuy.dto.ProductDTO;
import com.fiftyfive.bidNBuy.enums.ProductCategory;
import com.fiftyfive.bidNBuy.exceptions.ResourceNotFoundException;
import com.fiftyfive.bidNBuy.model.Product;
import com.fiftyfive.bidNBuy.repository.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void create(ProductDTO dto){
    productRepository.save(new Product(dto));
  }

  @Override
  public List<ProductDTO> findAllInCategory(ProductCategory category) {
    return productRepository.findAllByCategory(category).stream().map(product -> new ProductDTO(product))
        .collect(Collectors.toList());
  }

  @Override
  public ProductDTO findById(Long productId) {
    return new ProductDTO(
        productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", String.valueOf(productId))));
  }

  @Override
  public void setMinimumPrice(Long productId, Double minPrice) {
    productRepository.updateMinPrice(minPrice, productId);
  }
}