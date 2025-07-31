/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.lur.cinemagic.exception;

/**
 *
 * @author lur
 */
public class TicketNotFoundException extends RuntimeException {

	/**
	 * Creates a new instance of <code>TicketNotFoundException</code>
	 * without detail message.
	 */
	public TicketNotFoundException() {
	}

	/**
	 * Constructs an instance of <code>TicketNotFoundException</code> with
	 * the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public TicketNotFoundException(String msg) {
		super(msg);
	}
}
