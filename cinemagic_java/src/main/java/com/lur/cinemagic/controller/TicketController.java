/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.controller;

import com.lur.cinemagic.dto.ticket.TicketCreateDTO;
import com.lur.cinemagic.dto.ticket.TicketDetailsDto;
import com.lur.cinemagic.exception.NotValidDataException;
import com.lur.cinemagic.service.TicketService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author lur
 */
@RestController
@RequestMapping("cinemagic")
@AllArgsConstructor
public class TicketController {

	private TicketService service;

	// ENDPOINTS ALLOWED FOR ADMINS
	/**
	 * Get all tickets by using endpoint "cinemagic/ticket"
	 *
	 * @return Response Entity with the all the tickets stored in DB
	 */
	@GetMapping("/ticket")
	public ResponseEntity<List<TicketDetailsDto>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@DeleteMapping("/ticket/{idTicket}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}

	/**
	 * @param idShow
	 * @return
	 */
	@GetMapping("/show/{idShow}/ticket")
	public ResponseEntity<List<TicketDetailsDto>> getAllByIdShow(@PathVariable Long idShow) {
		return ResponseEntity.ok(service.getAllByIdShow(idShow));
	}

	// ENDPOINTS ALLOWED FOR ADMINS AND USERS
	/**
	 * Get a Ticket by id from DB using endpoint "cinemagic/ticket/{id}"
	 *
	 * @param id Ticket id
	 * @return
	 */
	@GetMapping("/ticket/{id}")
	public ResponseEntity<TicketDetailsDto> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	//endpoint allowed for user
	@PostMapping("/ticket")
	public ResponseEntity<TicketDetailsDto> insert(@Valid @RequestBody TicketCreateDTO ticketCreateDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new NotValidDataException("Validation error", bindingResult);
		}
		return ResponseEntity.ok(service.insert(ticketCreateDTO));
	}
}
