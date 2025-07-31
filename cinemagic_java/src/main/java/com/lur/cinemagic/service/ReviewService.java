/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.service;

import com.lur.cinemagic.dto.review.ReviewCreateDto;
import com.lur.cinemagic.dto.review.ReviewDetailsDto;
import com.lur.cinemagic.dto.review.ReviewUpdateDto;
import com.lur.cinemagic.exception.MovieReviewFromCurrentUserAlreadyExists;
import com.lur.cinemagic.exception.ReviewNotFoundException;
import com.lur.cinemagic.exception.UserOperationNotAllowed;
import com.lur.cinemagic.model.CinemaUser;
import com.lur.cinemagic.model.Movie;
import com.lur.cinemagic.model.Review;
import com.lur.cinemagic.repository.ReviewRepository;
import java.time.LocalDate;
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
public class ReviewService {

  private ReviewRepository repository;
  private MovieService movieService;
  private CinemaUserService cinemaUserService;

  public ReviewDetailsDto getReviewDetailsById(Long id) {
    Review review = this.getReviewById(id);
    return ReviewDetailsDto.getReviewDetailsDtoFromReview(review);
  }

  public List<ReviewDetailsDto> getReviewDetailsByIdMovie(Long idMovie, int page, int limit) {
    int offset = (page - 1) * limit;
    List<Review> reviews = repository.getReviewDetailsByIdMovie(idMovie, offset, limit);
    List<ReviewDetailsDto> reviewDetailsDtos = new ArrayList<>();
    for (Review review : reviews) {
      reviewDetailsDtos.add(ReviewDetailsDto.getReviewDetailsDtoFromReview(review));
    }
    return reviewDetailsDtos;
  }

  public ReviewDetailsDto insert(ReviewCreateDto reviewCreateDto) {
    CinemaUser user = cinemaUserService.getCurrentUser();
    if (repository.existsByUserIdAndMovieId(user.getId(), reviewCreateDto.getIdMovie())) {
      throw new MovieReviewFromCurrentUserAlreadyExists(
          "User " + user.getUsername() + " already has a review for movie with id=" + reviewCreateDto.getIdMovie());
    }

    Movie movie = movieService.getMovieById(reviewCreateDto.getIdMovie());
    Review review = new Review();

    review.setCalification(reviewCreateDto.getCalification());
    review.setContent(reviewCreateDto.getContent());
    review.setDate(LocalDate.now());
    review.setMovie(movie);
    review.setUser(user);
    review = repository.save(review);
    return ReviewDetailsDto.getReviewDetailsDtoFromReview(review);
  }

  public ReviewDetailsDto update(ReviewUpdateDto reviewUpdateDto) {
    Review review = this.getReviewById(reviewUpdateDto.getId());
    CinemaUser user = cinemaUserService.getCurrentUser();

    if (review.getUser().getId() != user.getId()) {
      throw new UserOperationNotAllowed("User " + user.getUsername() + " can not modify review with id="
          + review.getId() + ", since it is not yours");
    }

    review.setCalification(reviewUpdateDto.getCalification());
    review.setContent(reviewUpdateDto.getContent());

    return ReviewDetailsDto.getReviewDetailsDtoFromReview(repository.save(review));
  }

  public void deleteById(Long id) {
    CinemaUser user = cinemaUserService.getCurrentUser();
    Review review = this.getReviewById(id);

    if (review.getUser().getId() != user.getId()) {
      throw new UserOperationNotAllowed("User " + user.getUsername() + " can not delete review with id="
          + review.getId() + ", since it is not yours");
    }

    repository.deleteById(id);
  }

  public Review getReviewById(Long id) {
    return repository.findById(id).orElseThrow(
        () -> new ReviewNotFoundException("Review with id=" + id + " not found"));
  }
}
