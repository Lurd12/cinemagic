/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.showing;

import com.lur.cinemagic.dto.movie.MovieDetailsDto;
import com.lur.cinemagic.dto.theater.TheaterDetailsDto;
import com.lur.cinemagic.model.Showing;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lur
 */
@Getter
@Setter
public class ShowingDetailsDto {

	private Long id;
	private LocalDateTime dateTime;
	private double price;
	private MovieDetailsDto movieDto;
	private TheaterDetailsDto theaterDto;

	public static ShowingDetailsDto getShowingDetailsDtoFromShowing(Showing show) {
		ShowingDetailsDto showingDetailsDto = new ShowingDetailsDto();
		showingDetailsDto.setId(show.getId());
		showingDetailsDto.setDateTime(show.getDateTime());
		showingDetailsDto.setMovieDto(MovieDetailsDto.getMovieDetailsFromMovie(show.getMovie()));
		showingDetailsDto.setPrice(show.getPrice());
		showingDetailsDto.setTheaterDto(TheaterDetailsDto.getTheaterDetailsDtoFromTheater(show.getTheater()));
		return showingDetailsDto;
	}
}
