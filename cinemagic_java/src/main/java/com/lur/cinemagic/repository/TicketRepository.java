/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lur.cinemagic.repository;

import com.lur.cinemagic.model.Showing;
import org.springframework.data.repository.query.Param;
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
	List<Ticket> findAllByIdShow(Long idShow);


	boolean existsByShowAndSeatNumber(Showing show, int seatNumber);

}
