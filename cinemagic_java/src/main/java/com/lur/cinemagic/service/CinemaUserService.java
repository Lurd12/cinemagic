/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.service;

import com.lur.cinemagic.dto.cinemauser.CinemaUserCreateDto;
import com.lur.cinemagic.dto.cinemauser.CinemaUserDetailsDto;
import com.lur.cinemagic.dto.cinemauser.CinemaUserUpdateDto;
import com.lur.cinemagic.exception.UserOperationNotAllowed;
import com.lur.cinemagic.exception.UsernameAlreadyExistsException;
import com.lur.cinemagic.model.CinemaUser;
import com.lur.cinemagic.repository.CinemaUserRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author lur
 */
@Service
@AllArgsConstructor
public class CinemaUserService {

  private CinemaUserRepository repository;
  private PasswordEncoder passwordEncoder;

  public CinemaUser register(CinemaUserCreateDto cinemaUserDto) {
    if (repository.existsByUsername(cinemaUserDto.getUsername())) {
      throw new UsernameAlreadyExistsException("Username " + cinemaUserDto.getUsername() + " is already in use");
    }

    CinemaUser cinemaUser = new CinemaUser();
    cinemaUser.setUsername(cinemaUserDto.getUsername());
    cinemaUser.setPassword(passwordEncoder.encode(cinemaUserDto.getPassword()));
    cinemaUser.setRole("USER");
    return repository.save(cinemaUser);
  }

  public List<CinemaUser> getAll() {
    return repository.findAll();
  }

  public CinemaUserDetailsDto getCurrentUserDto() {
    CinemaUser currentUser = this.getCurrentUser();
    CinemaUserDetailsDto cinemaUserDetailsDto = new CinemaUserDetailsDto();
    cinemaUserDetailsDto.setId(currentUser.getId());
    cinemaUserDetailsDto.setUsername(currentUser.getUsername());
    return cinemaUserDetailsDto;
  }

  public CinemaUserDetailsDto update(CinemaUserUpdateDto cinemaUserUpdateDto) {
    CinemaUser currentUser = this.getCurrentUser();

    if (this.getCurrentUser().getId() != cinemaUserUpdateDto.getId()) {
      throw new UserOperationNotAllowed(
          "You can not edit user with id=" + cinemaUserUpdateDto.getId() + ", since it is not your own user");
    }

    if (repository.existsByUsername(cinemaUserUpdateDto.getUsername())) {
      throw new UsernameAlreadyExistsException("Username " + cinemaUserUpdateDto.getUsername() + " is already in use");
    }
    CinemaUserDetailsDto cinemaUserDetailsDto = new CinemaUserDetailsDto();

    currentUser.setUsername(cinemaUserUpdateDto.getUsername());
    currentUser.setPassword(passwordEncoder.encode(cinemaUserUpdateDto.getPassword()));
    currentUser = repository.save(currentUser);

    cinemaUserDetailsDto.setId(currentUser.getId());
    cinemaUserDetailsDto.setUsername(currentUser.getUsername());
    return cinemaUserDetailsDto;

  }

  public CinemaUser getCurrentUser() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return repository.findByUsername(auth.getName())
        .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

  }
}
