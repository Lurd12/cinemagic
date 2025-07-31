/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.controller;

import com.lur.cinemagic.dto.movie.MovieCreateDto;
import com.lur.cinemagic.dto.movie.MovieDetailsDto;
import com.lur.cinemagic.dto.movie.MovieUpdateDto;
import com.lur.cinemagic.exception.NotValidDataException;
import com.lur.cinemagic.service.MovieService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lur
 */
@RestController
@RequestMapping("cinemagic/movie")
@AllArgsConstructor
public class MovieController {

	private MovieService service;

	// ENDPOINTS ALLOWED FOR ADMINS
	@PostMapping
	public ResponseEntity<MovieDetailsDto> insert(@Valid @RequestBody MovieCreateDto movieDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new NotValidDataException("Validation error", bindingResult);
		}
		return ResponseEntity.ok(service.insert(movieDto));
	}

	@PutMapping
	public ResponseEntity<MovieDetailsDto> update(@Valid @RequestBody MovieUpdateDto movieDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new NotValidDataException("Validation error", bindingResult);
		}
		return ResponseEntity.ok(service.update(movieDto));
	}

	@DeleteMapping("/id")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}

	//ENDPOINTS ALLOWED FOR ANYONE
	@GetMapping
	public ResponseEntity<List<MovieDetailsDto>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<MovieDetailsDto> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@GetMapping("/search")
	public ResponseEntity<List<MovieDetailsDto>> getByKeyword(@RequestParam String keyword) {
		return ResponseEntity.ok(service.getByKeyword(keyword));
	}
}
