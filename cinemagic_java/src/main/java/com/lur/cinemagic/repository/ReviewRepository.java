/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.repository;

import com.lur.cinemagic.model.Review;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lur
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

		@Query(value = "SELECT * FROM review WHERE id_movie=:idMovie ORDER BY date LIMIT :limit OFFSET :offset", nativeQuery = true)
	List<Review> getReviewDetailsByIdMovie(Long idMovie, int offset, int limit);

	boolean existsByUserIdAndMovieId(Long idUser, Long idMovie);
	
}
