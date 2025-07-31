/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.theater;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

/**
 *
 * @author lur
 */
@Getter
@Setter
public class TheaterCreateDto {
	@NotNull(message = "Total seats must not be null")
	@Min(value=1,message = "Total seats must be >= 1")
	private int totalSeats;
	@NotBlank(message ="Theater name must not be blank")
	private String name;
	@NotNull(message = "IdBranch must not be null")
	@Min(value = 1, message = "IdBranch must not be < 1")
	private Long idBranch;
}
