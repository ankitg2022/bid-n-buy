package com.fiftyfive.bidNBuy.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  protected InMemoryUserDetailsManager configAuthentication() {
    List<UserDetails> users = new ArrayList<>();

    List<SimpleGrantedAuthority> sellerAuthorities = new ArrayList<>(List.of(new SimpleGrantedAuthority(("SELLER"))));

    UserDetails seller = new User("flipkart", "seller123", sellerAuthorities);
    users.add(seller);

    List<SimpleGrantedAuthority> customerAuthorities = new ArrayList<>(List.of(new SimpleGrantedAuthority(("CUSTOMER"))));

    UserDetails customer = new User("ankit", "ankit123", customerAuthorities);
    users.add(customer);

    customer = new User("orussa", "orussa123", customerAuthorities);
    users.add(customer);

    return new InMemoryUserDetailsManager(users);
  }

  public SecurityFilterChain filterChain(HttpSecurity http) {
    http
        .formLogin(withDefaults());
    // ...
  }

  @Bean
  protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //declares which Page(URL) will have What access type
    http.cors().disable().csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers("/login", "/accessDenied").permitAll()
        .requestMatchers("/admin/**").hasAuthority("ADMIN")
        .requestMatchers("/customer/**").hasAuthority("CUSTOMER")
        .anyRequest().authenticated()

        // Login Form Details
        .and()
        .formLogin()
//        .defaultSuccessUrl("/welcome", true)

        // Logout Form Details
        .and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

        // Exception Details
        .and()
        .exceptionHandling()
        .accessDeniedPage("/accessDenied")
    ;
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
