package com.fiftyfive.bidNBuy.controllers;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestController {

  @GetMapping(value = "/")
  public String login() {
    return "login";
  }

  @GetMapping(value = "/defaultPage")
  public String defaultPage(Principal principal, Model model) {
    if (principal.getName().equals("seller")) {
      return "redirect:/seller/Mobiles";
    } else {
      return "redirect:/customer/Mobiles";
    }
  }
}
