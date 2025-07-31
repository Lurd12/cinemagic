/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lur.cinemagic.repository;

import org.springframework.stereotype.Repository;
import com.lur.cinemagic.model.Ticket;
import java.util.List;

/**
 *
 * @author lur
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query(value = "SELECT * FROM ticket WHERE id_show=:idShow", nativeQuery = true)
	public List<Ticket> findAllByIdShow(Long idShow);

	@Query(value = """
		       SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END
		       FROM ticket
		       WHERE id_show =:idShow AND seat_number =:seatNumber""", nativeQuery = true)
	public boolean existsByIdShowAndSeatNumber(Long idShow, int seatNumber);

}
