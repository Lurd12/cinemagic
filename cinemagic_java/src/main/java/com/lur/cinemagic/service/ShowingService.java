/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.service;

import com.lur.cinemagic.dto.showing.ShowingCreateDto;
import com.lur.cinemagic.dto.showing.ShowingDetailsDto;
import com.lur.cinemagic.dto.showing.ShowingUpdateDto;
import com.lur.cinemagic.exception.ShowingNotFoundException;
import com.lur.cinemagic.model.Movie;
import com.lur.cinemagic.model.Showing;
import com.lur.cinemagic.model.Theater;
import com.lur.cinemagic.model.Ticket;
import com.lur.cinemagic.repository.ShowingRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

/**
 *
 * @author lur
 */
@Service
@AllArgsConstructor
public class ShowingService {

	private ShowingRepository repository;
	private TheaterService theaterService;
	private MovieService movieService;
	private TicketService ticketService;

	public List<ShowingDetailsDto> getNextShows() {
		List<Showing> shows = repository.findUpcommingShows();
		List<ShowingDetailsDto> showingDetailsDtos = new ArrayList<>();
		for (Showing show : shows) {
			showingDetailsDtos.add(ShowingDetailsDto.getShowingDetailsDtoFromShowing(show));
		}
		return showingDetailsDtos;
	}

	public List<ShowingDetailsDto> getByTheaterIdMovieIdKeyword(Long theaterId, Long movieId, String keyword) {

		List<Showing> shows = repository.findByTheaterIdMovieIdKeyword(theaterId, movieId, keyword);
		List<ShowingDetailsDto> showingDetailsDtos = new ArrayList<>();
		for (Showing show : shows) {
			showingDetailsDtos.add(ShowingDetailsDto.getShowingDetailsDtoFromShowing(show));
		}
		return showingDetailsDtos;
	}

	public List<ShowingDetailsDto> getAll() {
		List<Showing> shows = repository.findAll();
		List<ShowingDetailsDto> showingDetailsDtos = new ArrayList<>();
		for (Showing show : shows) {
			showingDetailsDtos.add(ShowingDetailsDto.getShowingDetailsDtoFromShowing(show));
		}
		return showingDetailsDtos;
	}

	public ShowingDetailsDto getById(Long id) {
		Showing show = repository.findById(id).orElseThrow(
			() -> new ShowingNotFoundException("Show with id=" + id + " not found")
		);
		return ShowingDetailsDto.getShowingDetailsDtoFromShowing(show);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public ShowingDetailsDto update(ShowingUpdateDto showingUpdateDto) {
		Showing show = repository.findById(showingUpdateDto.getId()).orElseThrow(
			() -> new ShowingNotFoundException("Show with id=" + showingUpdateDto.getId() + " not found")
		);
		Movie movie = movieService.getMovieById(showingUpdateDto.getMovieId());
		Theater theater = theaterService.getById(showingUpdateDto.getTheaterId());
		show.setDateTime(showingUpdateDto.getDateTime());
		show.setMovie(movie);
		show.setPrice(showingUpdateDto.getPrice());
		show.setTheater(theater);
		return ShowingDetailsDto.getShowingDetailsDtoFromShowing(repository.save(show));
	}

	public ShowingDetailsDto insert(ShowingCreateDto showingCreateDto) {
		Showing show = new Showing();
		Movie movie = movieService.getMovieById(showingCreateDto.getMovieId());
		Theater theater = theaterService.getById(showingCreateDto.getTheaterId());

		show.setDateTime(showingCreateDto.getDateTime());
		show.setMovie(movie);
		show.setPrice(showingCreateDto.getPrice());
		show.setTheater(theater);

		return ShowingDetailsDto.getShowingDetailsDtoFromShowing(repository.save(show));
	}

	public Showing getShowingById(Long id) {
		return repository.findById(id).orElseThrow(
			() -> new ShowingNotFoundException("Show with id=" + id + " not found")
		);
	}


	public Map<String, Object> getSeatsByAvailabilityAndIdShow(Long idShow, boolean available){
		List<Integer> usedSeats = new ArrayList<>();

		//Verify if the show exists
		Showing show = this.getShowingById(idShow);

		//Get every ticket
		List<Ticket> tickets = ticketService.getAllTicketsByIdShow(idShow);


		for(Ticket ticket: tickets){
			usedSeats.add(ticket.getSeatNumber());
		}

		//Sort seats
		Collections.sort(usedSeats);

		if(!available){
			return Map.of("idShow", idShow, "usedSeats", usedSeats);
		}
			List<Integer> unusedSeats = new ArrayList<>();
			for(int i = 1; i<= show.getTheater().getTotalSeats(); i++){
				if(!usedSeats.contains(i)){
					unusedSeats.add(i);
				}
			}

			return Map.of("idShow", idShow, "unusedSeats", unusedSeats);
	}
}
