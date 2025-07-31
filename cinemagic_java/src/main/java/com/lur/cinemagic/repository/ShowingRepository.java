/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.repository;

import com.lur.cinemagic.model.Showing;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lurs
 */
@Repository
public interface ShowingRepository extends JpaRepository<Showing, Long> {

	@Query(value = "SELECT * FROM showing WHERE date_time >= NOW()", nativeQuery = true)
	List<Showing> findUpcommingShows();

	@Query("""
        SELECT s FROM Showing s
        WHERE (:movieId IS NULL OR s.movie.id = :movieId)
        AND (:keyword IS NULL OR LOWER(s.movie.title) LIKE LOWER(CONCAT('%', :keyword, '%')))
        AND (:theaterId IS NULL OR s.theater.id = :theaterId)
        """)
	List<Showing> findByTheaterIdMovieIdKeyword(Long movieId, Long theaterId, String keyword);
}
