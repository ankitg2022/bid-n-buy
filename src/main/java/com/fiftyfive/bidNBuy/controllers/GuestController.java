package com.fiftyfive.bidNBuy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestController {

  @GetMapping(value = "/")
  public String login() {
    return "login";
  }

}
