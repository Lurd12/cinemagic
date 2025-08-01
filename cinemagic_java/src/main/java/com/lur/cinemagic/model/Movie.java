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
@Setter
@Getter
public class Movie {
	@Id
	@Column(name="id_movie")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private int duration;
	private String synopsis;
	
	@OneToMany(mappedBy = "movie")
	private List<Review> reviews;
	
	@OneToMany(mappedBy = "movie")
	private List<Showing> shows;
	
	public double getCalification(){
		int prom = 0;

		if(reviews == null || reviews.isEmpty()){
			return prom;
		}
		for(Review r: reviews){
			prom += r.getCalification();
		}
		prom /=reviews.size();
		return prom;
	}
	
	
}
