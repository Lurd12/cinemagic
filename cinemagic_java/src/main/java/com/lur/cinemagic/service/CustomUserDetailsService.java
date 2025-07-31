/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.service;

import com.lur.cinemagic.model.CinemaUser;
import com.lur.cinemagic.repository.CinemaUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author lur
 */
@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private CinemaUserRepository cinemaUserRepository;

  @Override
  public UserDetails loadUserByUsername(String username)
      throws org.springframework.security.core.userdetails.UsernameNotFoundException {
    CinemaUser cinemaUser = cinemaUserRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
    System.out.println(cinemaUser.getUsername());
    return User.builder()
        .username(cinemaUser.getUsername())
        .password(cinemaUser.getPassword()) // should be encoded
        .roles(cinemaUser.getRole()) // e.g., "USER", "ADMIN"
        .build();
  }

}
