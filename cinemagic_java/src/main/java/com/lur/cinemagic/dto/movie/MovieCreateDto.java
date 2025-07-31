/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.movie;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lur
 */
@Getter
@Setter
public class MovieCreateDto {
	@NotBlank(message = "Title must not be blank")
	@NotNull(message = "Title must not be null")
	private String title;
	@NotNull(message = "Movie duration must not be null")
	@Min(value=1, message="Movie duration must be at least 1 min")
	private int duration;
	@NotBlank(message = "Synopsis must not be blank")
	@NotNull(message = "Synopsis must not be null")
	private String synopsis;
}
