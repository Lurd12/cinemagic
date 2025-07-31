/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lur
 */
@Entity
@Getter
@Setter
public class CinemaUser {
	@Id
	@Column(name="id_viewer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String role;
	
	@OneToMany(mappedBy = "user")
	private List<Review> reviews;
	
	@OneToMany(mappedBy = "user")
	private List<Ticket> tickets;
	
	
}
