/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;
import lombok.Getter;

/**
 *
 * @author lur
 */
@Getter
@Setter
public class ReviewUpdateDto {

	@NotNull(message = "Id must not be null")
	@Min(value = 1, message = "Id must not be < 1")
	private Long id;
	
	@Min(value = 0, message = "Calification must be >= 0")
	@Max(value = 10, message = "Calification must be <= 10")
	@NotNull(message = "Calification must not be null")
	private int calification;
	@NotBlank(message = "Content must not be blank")
	private String content;
}
