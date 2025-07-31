/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.repository;

import com.lur.cinemagic.model.CinemaUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lur
 */
@Repository
public interface CinemaUserRepository extends JpaRepository<CinemaUser, Long> {
	Optional<CinemaUser> findByUsername(String username);
	
	boolean existsByUsername(String username);
}
