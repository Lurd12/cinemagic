/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license Click
 * nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this
 * template
 */
package com.lur.cinemagic.controller;

import com.lur.cinemagic.exception.BranchNotFoundException;
import com.lur.cinemagic.exception.InvalidSeatChoiceException;
import com.lur.cinemagic.exception.MovieNotFoundException;
import com.lur.cinemagic.exception.MovieReviewFromCurrentUserAlreadyExists;
import com.lur.cinemagic.exception.NotValidDataException;
import com.lur.cinemagic.exception.ReviewNotFoundException;
import com.lur.cinemagic.exception.ShowFullOfPeopleException;
import com.lur.cinemagic.exception.ShowingNotFoundException;
import com.lur.cinemagic.exception.TheaterNotFoundException;
import com.lur.cinemagic.exception.TicketNotFoundException;
import com.lur.cinemagic.exception.UserOperationNotAllowed;
import com.lur.cinemagic.exception.UsernameAlreadyExistsException;
import java.util.Map;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author lur
 */
@ControllerAdvice
public class ControllerHandlerAdvise {

	@ExceptionHandler(NotValidDataException.class)
	public ResponseEntity<?> validacionEntradaDatos(NotValidDataException notValidDataException) {
		Map<String, String> errores = new HashMap<>();
		notValidDataException.getBindingResult().getFieldErrors().forEach(f -> errores.put(f.getField(), f.getDefaultMessage()));
		return ResponseEntity.badRequest().body(errores);
	}

	@ExceptionHandler(BranchNotFoundException.class)
	public ResponseEntity<Map<String, String>> branchNotFound(BranchNotFoundException ex) {
		return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
	}

	@ExceptionHandler(InvalidSeatChoiceException.class)
	public ResponseEntity<Map<String, String>> invalidSeatChoice(InvalidSeatChoiceException ex) {
		return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
	}

	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<Map<String, String>> movieNotFound(MovieNotFoundException ex) {
		return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
	}

	@ExceptionHandler(MovieReviewFromCurrentUserAlreadyExists.class)
	public ResponseEntity<Map<String, String>> movieReviewAlreadyExists(MovieReviewFromCurrentUserAlreadyExists ex) {
		return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
	}

	@ExceptionHandler(ReviewNotFoundException.class)
	public ResponseEntity<Map<String, String>> reviewNotFound(ReviewNotFoundException ex) {
		return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
	}

	@ExceptionHandler(ShowFullOfPeopleException.class)
	public ResponseEntity<Map<String, String>> showFull(ShowFullOfPeopleException ex) {
		return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
	}

	@ExceptionHandler(ShowingNotFoundException.class)
	public ResponseEntity<Map<String, String>> showingNotFound(ShowingNotFoundException ex) {
		return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
	}

	@ExceptionHandler(TheaterNotFoundException.class)
	public ResponseEntity<Map<String, String>> theaterNotFound(TheaterNotFoundException ex) {
		return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
	}

	@ExceptionHandler(TicketNotFoundException.class)
	public ResponseEntity<Map<String, String>> ticketNotFound(TicketNotFoundException ex) {
		return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
	}

	@ExceptionHandler(UserOperationNotAllowed.class)
	public ResponseEntity<Map<String, String>> userOperationNotAllowed(UserOperationNotAllowed ex) {
		return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
	}

	@ExceptionHandler(UsernameAlreadyExistsException.class)
	public ResponseEntity<Map<String, String>> usernameAlreadyExists(UsernameAlreadyExistsException ex) {
		return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
	}
}
