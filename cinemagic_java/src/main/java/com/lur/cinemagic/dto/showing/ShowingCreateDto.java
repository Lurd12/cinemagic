/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.showing;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.bridge.Message;

/**
 *
 * @author lur
 */
@Getter
@Setter
public class ShowingCreateDto {
	@NotNull(message = "Datetime must not be null")
	@Future(message = "Show datetime must be a date int the future")
	private LocalDateTime dateTime;
	@NotNull(message = "Price must not be null")
	@DecimalMin(value = "0.00", message = "Price must be >= 0.00")
	private double price;
	@NotNull(message = "MovieId must not be null")
	@Min(value = 1, message = "MovieId must not be < 1")
	private Long movieId;
	@NotNull(message = "TheaterId must not be null")
	@Min(value = 1, message = "TheaterId must not be < 1")
	private Long theaterId;
}
