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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
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
public class Showing {
	@Id
	@Column(name="id_show")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dateTime;
	
	private double price;
	
	@ManyToOne
	@JoinColumn(name="id_movie")
	private Movie movie;

	@ManyToOne
	@JoinColumn(name="id_theater")
	private Theater theater;
	
	@OneToMany(mappedBy = "show")
	private List<Ticket> tickets;
}
