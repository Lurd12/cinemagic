/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.review;

import com.lur.cinemagic.dto.cinemauser.CinemaUserDetailsDto;
import com.lur.cinemagic.model.Review;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lur
 */
@Getter
@Setter
public class ReviewDetailsDto {
	private Long id;
	private int calification;
	private String content;
	private LocalDate date;
	private Long idMovie;
	private CinemaUserDetailsDto cinemaUserDetailsDto;
	
	
	public static ReviewDetailsDto getReviewDetailsDtoFromReview(Review review){
		ReviewDetailsDto reviewDetailsDto = new ReviewDetailsDto();
		
		reviewDetailsDto.setCalification(review.getCalification());
		reviewDetailsDto.setContent(review.getContent());
		reviewDetailsDto.setId(review.getId());
		reviewDetailsDto.setIdMovie(review.getMovie().getId());
		reviewDetailsDto.setDate(review.getDate());
		reviewDetailsDto.setCinemaUserDetailsDto(CinemaUserDetailsDto.getCinemaUserDetailsDtoFromUser(review.getUser()));
		return reviewDetailsDto;
	}
}
