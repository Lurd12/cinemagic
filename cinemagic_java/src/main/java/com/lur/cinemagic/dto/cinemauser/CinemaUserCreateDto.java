/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.cinemauser;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lur
 */
@Setter
@Getter
public class CinemaUserCreateDto {

	@NotBlank(message = "Username must not be blank")
	@NotNull(message = "Username must not be null")
	private String username;
	@NotBlank(message = "Password must not be blank")
	@NotNull(message = "Password must not be null")
	@Size(min=8, message = "Password must have at least 8 characters")
	private String password;
}
