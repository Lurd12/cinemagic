package com.lur.cinemagic.controller;

import com.lur.cinemagic.dto.showing.ShowingCreateDto;
import com.lur.cinemagic.dto.showing.ShowingDetailsDto;
import com.lur.cinemagic.dto.showing.ShowingUpdateDto;
import com.lur.cinemagic.exception.NotValidDataException;
import com.lur.cinemagic.service.ShowingService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
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
@AllArgsConstructor
@RestController
@RequestMapping("cinemagic/show")
public class ShowingController {

	private ShowingService service;

	// ALLOWED FOR EVERYONE
	@GetMapping("/next")
	public ResponseEntity<List<ShowingDetailsDto>> getNextShows() {
		return ResponseEntity.ok(service.getNextShows());
	}

	@GetMapping("/search")
	public ResponseEntity<List<ShowingDetailsDto>>
		getByTheaterIdMovieIdKeyword(@RequestParam(required = false) Long theaterId,
			@RequestParam(required = false) Long movieId,
			@RequestParam(required = false) String keyword) {
		return ResponseEntity.ok(
			service.getByTheaterIdMovieIdKeyword(theaterId, movieId, keyword));
	}

	@GetMapping
	public ResponseEntity<List<ShowingDetailsDto>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ShowingDetailsDto> getByid(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@GetMapping("/{id}/seats")
	public ResponseEntity<Map<String, Object>>
		getSeatsByAvailability(@PathVariable Long id,
			@RequestParam(required = true) boolean available) {
		return ResponseEntity.ok(
			service.getSeatsByAvailabilityAndIdShow(id, available));
	}
	// ALLOWED FOR ADMINS

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {

		service.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	public ResponseEntity<ShowingDetailsDto>
		update(@Valid @RequestBody ShowingUpdateDto showingDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new NotValidDataException("Validation error", bindingResult);
		}
		return ResponseEntity.ok(service.update(showingDto));
	}

	@PostMapping
	public ResponseEntity<ShowingDetailsDto>
		insert(@Valid @RequestBody ShowingCreateDto showindDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new NotValidDataException("Validation error", bindingResult);
		}
		return ResponseEntity.ok(service.insert(showindDto));
	}
}
