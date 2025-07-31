/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.controller;

import com.lur.cinemagic.dto.cinemauser.CinemaUserCreateDto;
import com.lur.cinemagic.dto.cinemauser.CinemaUserDetailsDto;
import com.lur.cinemagic.dto.cinemauser.CinemaUserUpdateDto;
import com.lur.cinemagic.exception.NotValidDataException;
import com.lur.cinemagic.model.CinemaUser;
import com.lur.cinemagic.service.CinemaUserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author lur
 */
@RestController
@RequestMapping("cinemagic/user")
@AllArgsConstructor
public class CinemaUserController {

	private CinemaUserService service;

	// ENDPOINTS ALLOWED FOR ANYONE
	@PostMapping("/register")
	public ResponseEntity<CinemaUser> register(@Valid @RequestBody CinemaUserCreateDto cinemaUserDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new NotValidDataException("Validation error", bindingResult);

		}
		return ResponseEntity.ok(service.register(cinemaUserDto));
	}

	// ENDPOINS ONLY ALLOWED FOR ADMINS
	@GetMapping
	public ResponseEntity<List<CinemaUser>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	// ENDPOINTS ONLY ALLOWED FOR USERS
	@GetMapping("/profile")
	public ResponseEntity<CinemaUserDetailsDto> getCurrentUser() {
		return ResponseEntity.ok(service.getCurrentUserDto());
	}

	@PutMapping("/profile")
	public ResponseEntity<CinemaUserDetailsDto> update(@Valid @RequestBody CinemaUserUpdateDto cinemaUserDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new NotValidDataException("Validation error", bindingResult);
			
		}
		return ResponseEntity.ok(service.update(cinemaUserDto));
	}

}
