/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.cinemauser;
import com.lur.cinemagic.model.CinemaUser;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lur
 */
@Setter
@Getter
public class CinemaUserDetailsDto{
	private Long id;
	private String username;
	
	
	public static CinemaUserDetailsDto getCinemaUserDetailsDtoFromUser(CinemaUser user){
		CinemaUserDetailsDto cinemaUserDetailsDto  = new CinemaUserDetailsDto();
		cinemaUserDetailsDto.setId(user.getId());
		cinemaUserDetailsDto.setUsername(user.getUsername());
		
		return cinemaUserDetailsDto;
	}
}
