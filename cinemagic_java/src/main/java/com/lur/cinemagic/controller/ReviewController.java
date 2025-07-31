/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license Click
 * nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this
 * template
 */
package com.lur.cinemagic.controller;

import com.lur.cinemagic.dto.review.ReviewCreateDto;
import com.lur.cinemagic.dto.review.ReviewDetailsDto;
import com.lur.cinemagic.dto.review.ReviewUpdateDto;
import com.lur.cinemagic.exception.NotValidDataException;
import com.lur.cinemagic.service.ReviewService;
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
 * @author lur
 */
@RestController
@RequestMapping("cinemagic")
@AllArgsConstructor
public class ReviewController {

	private ReviewService service;

	// Allowed for everyone
	@GetMapping("/review/{id}")
	public ResponseEntity<ReviewDetailsDto> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getReviewDetailsById(id));
	}

	@GetMapping("/movie/{idMovie}/review")
	public ResponseEntity<List<ReviewDetailsDto>>
		getByIdMovie(@PathVariable Long idMovie, int page, @RequestParam int limit) {
		return ResponseEntity.ok(
			service.getReviewDetailsByIdMovie(idMovie, page, limit));
	}

	// Allowed for users only
	@PostMapping("/review")
	public ResponseEntity<ReviewDetailsDto>
		insert(@Valid @RequestBody ReviewCreateDto reviewDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new NotValidDataException("Validation error", bindingResult);
		}
		return ResponseEntity.ok(service.insert(reviewDto));
	}

	@PutMapping("/review")
	public ResponseEntity<ReviewDetailsDto>
		update(@Valid @RequestBody ReviewUpdateDto reviewDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new NotValidDataException("Validation error", bindingResult);
		}
		return ResponseEntity.ok(service.update(reviewDto));
	}

	@DeleteMapping("/review/{id}")
	public ResponseEntity<ReviewDetailsDto> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
