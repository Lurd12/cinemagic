/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.movie;
import com.lur.cinemagic.model.Movie;
import lombok.Setter;
import lombok.Getter;
/**
 *
 * @author lur
 */
@Getter
@Setter
public class MovieDetailsDto extends MovieCreateDto{
	private Long id;
	
	private double calification;
	
	
	public static MovieDetailsDto getMovieDetailsFromMovie(Movie movie){
		MovieDetailsDto movieDetailsDto = new MovieDetailsDto();
		
		movieDetailsDto.setId(movie.getId());
		movieDetailsDto.setDuration(movie.getDuration());
		movieDetailsDto.setTitle(movie.getTitle());
		movieDetailsDto.setSynopsis(movie.getSynopsis());
		movieDetailsDto.setCalification(movie.getCalification());
		
		return movieDetailsDto;
	}
}
