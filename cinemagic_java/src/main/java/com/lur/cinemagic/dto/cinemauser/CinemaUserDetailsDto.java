/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.cinemauser;
import com.lur.cinemagic.model.CinemaUser;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		CinemaUserDetailsDto that = (CinemaUserDetailsDto) o;
		return Objects.equals(id, that.id) && Objects.equals(username, that.username);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username);
	}
}
