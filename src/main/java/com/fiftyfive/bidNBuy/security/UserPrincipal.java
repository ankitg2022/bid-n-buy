package com.fiftyfive.bidNBuy.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserPrincipal extends User {

  private static final long serialVersionUID = 8560843303984265407L;

  public UserPrincipal(String username, String password, Collection authorities) {
    super(username, password, authorities);
  }

  public static UserPrincipal create(String username, String password, String userRole) {
    List authorities = Collections.singletonList(new SimpleGrantedAuthority(userRole));
    return new UserPrincipal(username, password, authorities);
  }
}
