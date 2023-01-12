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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

  private final ProductService productService;
  private final BidService bidService;

  @GetMapping(value = "/products")
  public String viewAllProducts(Model model) {
    model.addAttribute("productList", productService.findAll());
    return "customer/products";
  }

  @GetMapping(value = "products/{productId}")
  public String findProductById(Model model, @PathVariable Long productId) {
    model.addAttribute("product", productService.findById(productId));
    model.addAttribute("bids", bidService.findAllByProductId(productId));
    BidDTO bidDTO = new BidDTO();
    bidDTO.setProductId(productId);
    model.addAttribute("bidDTO", bidDTO);
    return "customer/productDetails";
  }

  @PostMapping(value = "products")
  public String placeBid(@CurrentUser UserPrincipal currentUser, Model model, @ModelAttribute BidDTO bidDTO) {
    bidDTO.setValid(Boolean.TRUE);
//    bidDTO.setUsername(currentUser.getUsername());
    bidService.create(bidDTO);
    return "redirect:/customer/products/"+bidDTO.getProductId();
  }
}
