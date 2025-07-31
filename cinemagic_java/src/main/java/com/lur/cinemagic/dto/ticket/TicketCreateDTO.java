/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.ticket;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lur
 */
@Getter
@Setter
public class TicketCreateDTO {
	@Min(value = 1, message = "Seat number must be >= 1")
	@NotNull(message="Seat number must not be null")
	private int seatNumber;
	@NotNull(message = "IdShow must not be null")
	@Min(value = 1, message = "IdShow must not be < 1")
	private Long idShow;
}
