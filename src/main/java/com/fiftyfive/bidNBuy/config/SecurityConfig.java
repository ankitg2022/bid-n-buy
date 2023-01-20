package com.fiftyfive.bidNBuy.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public UserDetailsService userDetailsService(){
    UserDetails ankit = User.withUsername("ankit").password(passwordEncoder().encode("admin")).roles("CUSTOMER").build();
    UserDetails orussa = User.withUsername("orussa").password(passwordEncoder().encode("admin")).roles("CUSTOMER").build();
    UserDetails seller = User.withUsername("seller").password(passwordEncoder().encode("admin")).roles("SELLER").build();

    return new InMemoryUserDetailsManager(ankit, orussa, seller);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf().disable().cors().disable()
        .authorizeHttpRequests()
        .requestMatchers("/seller/**").hasRole("SELLER")
        .requestMatchers("/customer/**").hasRole("CUSTOMER")
        .requestMatchers("/defaultPage").hasAnyRole("CUSTOMER", "SELLER")
        .requestMatchers("/css/**", "/images/**", "/" ).permitAll()
        .anyRequest().authenticated()
        .and()
<<<<<<< HEAD
        .formLogin().defaultSuccessUrl("/defaultPage", true)
        .and()
        .logout().logoutSuccessUrl("/");
=======
        .formLogin().defaultSuccessUrl("/defaultPage", true);
>>>>>>> ba1f73c9d9b2a47a098b9c22d75d579b0ed3fc32

    return httpSecurity.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
}
