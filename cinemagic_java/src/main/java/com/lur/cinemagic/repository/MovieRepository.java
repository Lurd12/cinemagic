
package com.lur.cinemagic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.lur.cinemagic.model.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author lur
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	@Query("SELECT m FROM Movie m WHERE m.title LIKE CONCAT('%', :keyword, '%')")
	List<Movie> findByKeyword(String keyword);

}
