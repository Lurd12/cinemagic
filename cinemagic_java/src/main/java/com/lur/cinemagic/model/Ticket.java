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
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lur
 */
@Entity
@Getter
@Setter
public class Ticket implements Comparable<Ticket> {

	@Id
	@Column(name = "id_ticket")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int seatNumber;

	@ManyToOne
	@JoinColumn(name = "id_show")
	private Showing show;

	@ManyToOne
	@JoinColumn(name = "id_viewer")
	private CinemaUser user;

	@Override
	public int compareTo(Ticket t) {
		return seatNumber - t.getSeatNumber();
	}
}
