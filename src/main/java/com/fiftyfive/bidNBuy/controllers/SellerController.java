package com.fiftyfive.bidNBuy.controllers;

import com.fiftyfive.bidNBuy.dto.BidDTO;
import com.fiftyfive.bidNBuy.dto.ProductDTO;
import com.fiftyfive.bidNBuy.enums.ProductCategory;
import com.fiftyfive.bidNBuy.security.CurrentUser;
import com.fiftyfive.bidNBuy.security.UserPrincipal;
import com.fiftyfive.bidNBuy.service.BidService;
import com.fiftyfive.bidNBuy.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("seller/")
@RequiredArgsConstructor
public class SellerController {

  private final ProductService productService;
  private final BidService bidService;

  @GetMapping(value = "/{category}")
  public String viewAllProducts(Model model,@PathVariable ProductCategory category) {
    model.addAttribute("productList", productService.findAllInCategory(category));
    return "seller/products";
  }

  @GetMapping(value = "/bids/{productId}")
  public String editProduct(Model model, @PathVariable Long productId) {
    model.addAttribute("product", productService.findById(productId));
    model.addAttribute("bids", bidService.findAllByProductId(productId));
    return "seller/bids";
  }

  @PutMapping(value = "/{category}")
  public String updateBasePrice(Model model, @ModelAttribute ProductDTO product, @PathVariable ProductCategory category) {
    productService.setMinimumPrice(product.getProductId(), product.getMinPrice());
    return "seller/"+category;
  }
}
