/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.ticket;

import com.lur.cinemagic.dto.showing.ShowingDetailsDto;
import com.lur.cinemagic.model.Ticket;
import lombok.Setter;
import lombok.Getter;

/**
 *
 * @author lur
 */
@Getter
@Setter
public class TicketDetailsDto{
	private Long id;
	private int seatNumber;
	private ShowingDetailsDto showingDetailsDto;
	
	public static TicketDetailsDto getTicketDetailsDtoFromTicket(Ticket ticket){
		TicketDetailsDto ticketDetailsDto = new TicketDetailsDto();
		ticketDetailsDto.setId(ticket.getId());
		ticketDetailsDto.setSeatNumber(ticket.getSeatNumber());
		ticketDetailsDto.setShowingDetailsDto(ShowingDetailsDto.getShowingDetailsDtoFromShowing(ticket.getShow()));
		
		return ticketDetailsDto;
	}
}
