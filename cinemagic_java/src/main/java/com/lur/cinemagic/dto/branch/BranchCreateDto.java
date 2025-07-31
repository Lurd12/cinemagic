/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.branch;

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
public class BranchCreateDto {
	@NotNull(message = "Street must not be null")
	@NotBlank(message = "Street must not be blank")
	private String street;
	@NotNull(message = "Country must not be null")
	@NotBlank(message = "Country must not be blank")
	private String country;
	@NotNull(message = "State must not be null")
	@NotBlank(message = "State must not be blank")
	private String state;
	@NotNull(message = "Town must not be null")
	@NotBlank(message = "Town must not be blank")
	private String town;
	@NotNull(message = "External number must not be null")
	@Min(value = 1, message = "External number must not be negative or 0")
	private int extNumber;
}
