/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.service;

import com.lur.cinemagic.dto.ticket.TicketCreateDTO;
import com.lur.cinemagic.dto.ticket.TicketDetailsDto;
import com.lur.cinemagic.exception.InvalidSeatChoiceException;
import com.lur.cinemagic.exception.ShowFullOfPeopleException;
import com.lur.cinemagic.exception.TicketNotFoundException;
import com.lur.cinemagic.exception.UserOperationNotAllowed;
import com.lur.cinemagic.model.CinemaUser;
import com.lur.cinemagic.model.Showing;
import com.lur.cinemagic.model.Ticket;
import com.lur.cinemagic.repository.TicketRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author lur
 */
@Service
@AllArgsConstructor
public class TicketService {

	private TicketRepository repository;
	private ShowingService showingService;
	private CinemaUserService cinemaUserService;

	/**
	 * Get ticket by id from DB
	 *
	 * @param id Ticket id
	 * @param username
	 * @return Ticket
	 */
	public TicketDetailsDto getById(Long id) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean hasAdminRole = authentication.getAuthorities().stream()
			.anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
		Ticket ticket = repository.findById(id)
			.orElseThrow(() -> new TicketNotFoundException("Ticket with id=" + id + " not found"));
		if (hasAdminRole) {
			return TicketDetailsDto.getTicketDetailsDtoFromTicket(ticket);
		}
		if (!authentication.getName().equals(ticket.getUser().getUsername())) {
			throw new UserOperationNotAllowed("You can only access to your own tickets");
		}
		return TicketDetailsDto.getTicketDetailsDtoFromTicket(ticket);
	}

	public List<TicketDetailsDto> getAll() {
		List<Ticket> tickets = repository.findAll();
		List<TicketDetailsDto> ticketDetailsDtos = new ArrayList<>();

		for (Ticket ticket : tickets) {
			ticketDetailsDtos.add(TicketDetailsDto.getTicketDetailsDtoFromTicket(ticket));
		}
		return ticketDetailsDtos;
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public TicketDetailsDto insert(TicketCreateDTO ticketCreateDto) {
		CinemaUser user = cinemaUserService.getCurrentUser();

		//Excepcion en caso de un asiento mayor a los disponibles
		Showing show = showingService.getShowingById(ticketCreateDto.getIdShow());

		if (show.getTickets().size() == show.getTheater().getTotalSeats()) {
			throw new ShowFullOfPeopleException("All show tickets with id=" + ticketCreateDto.getIdShow() + " have been already selled");
		}

		if (show.getTheater().getTotalSeats() < ticketCreateDto.getSeatNumber()) {
			throw new InvalidSeatChoiceException("The greater seat number choice for show with id=" + ticketCreateDto.getIdShow() + " is " + show.getTheater().getTotalSeats());
		}

		if (repository.existsByShowAndSeatNumber(showingService.getShowingById(ticketCreateDto.getIdShow()), ticketCreateDto.getSeatNumber())) {
			throw new InvalidSeatChoiceException("Seat " + ticketCreateDto.getSeatNumber() + " is not available");
		}
		
		
		Ticket ticket = new Ticket();
		ticket.setSeatNumber(ticketCreateDto.getSeatNumber());
		ticket.setShow(show);
		ticket.setUser(user);
		
		return TicketDetailsDto.getTicketDetailsDtoFromTicket(repository.save(ticket));
	}

	public List<TicketDetailsDto> getAllByIdShow(Long idShow) {
		List<Ticket> tickets = this.getAllTicketsByIdShow(idShow);
		List<TicketDetailsDto> ticketDetailsDtos = new ArrayList<>();
		for (Ticket ticket : tickets) {
			ticketDetailsDtos.add(TicketDetailsDto.getTicketDetailsDtoFromTicket(ticket));
		}
		return ticketDetailsDtos;
	}



	public List<Ticket> getAllTicketsByIdShow(Long idShow){
		return repository.findAllByIdShow(idShow);
	}
}
