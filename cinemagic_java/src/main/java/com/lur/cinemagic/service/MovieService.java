/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.service;

import com.lur.cinemagic.dto.movie.MovieCreateDto;
import com.lur.cinemagic.dto.movie.MovieDetailsDto;
import com.lur.cinemagic.dto.movie.MovieUpdateDto;
import com.lur.cinemagic.exception.MovieNotFoundException;
import com.lur.cinemagic.model.Movie;
import com.lur.cinemagic.repository.MovieRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author lur
 */
@Service
@AllArgsConstructor
public class MovieService {

	private MovieRepository repository;

	public MovieDetailsDto insert(MovieCreateDto movieDto) {
		Movie movie = new Movie();
		movie.setDuration(movieDto.getDuration());
		movie.setSynopsis(movieDto.getSynopsis());
		movie.setTitle(movieDto.getTitle());
		movie = repository.save(movie);

		return MovieDetailsDto.getMovieDetailsFromMovie(movie);
	}

	public MovieDetailsDto update(MovieUpdateDto movieDto) {
		Movie movie = this.getMovieById(movieDto.getId());
		movie.setDuration(movieDto.getDuration());
		movie.setSynopsis(movieDto.getSynopsis());
		movie.setTitle(movieDto.getTitle());

		movie = repository.save(movie);

		return MovieDetailsDto.getMovieDetailsFromMovie(movie);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public List<MovieDetailsDto> getAll() {
		List<Movie> movies = repository.findAll();

		List<MovieDetailsDto> movieDetailsDtos = new ArrayList<>();

		for (Movie mov : movies) {
			movieDetailsDtos.add(MovieDetailsDto.getMovieDetailsFromMovie(mov));
		}

		return movieDetailsDtos;
	}

	public MovieDetailsDto getById(Long id) {
		Movie movie = this.getMovieById(id);
		
		return MovieDetailsDto.getMovieDetailsFromMovie(movie);
	}
	
	public List<MovieDetailsDto> getByKeyword(String keyword){
		List<Movie> movies = repository.findByKeyword(keyword);

		List<MovieDetailsDto> movieDetailsDtos = new ArrayList<>();

		for (Movie mov : movies) {
			movieDetailsDtos.add(MovieDetailsDto.getMovieDetailsFromMovie(mov));
		}

		return movieDetailsDtos;
	}
	
	public Movie getMovieById(Long id){
		return repository.findById(id).orElseThrow(
			() -> new MovieNotFoundException("Movie with id=" + id + " not found")
		);
	}
}
