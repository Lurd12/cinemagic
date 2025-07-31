/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.lur.cinemagic.exception;

/**
 *
 * @author lur
 */
public class TheaterNotFoundException extends RuntimeException {

	/**
	 * Creates a new instance of <code>TheaterNotFound</code> without detail
	 * message.
	 */
	public TheaterNotFoundException() {
	}

	/**
	 * Constructs an instance of <code>TheaterNotFound</code> with the
	 * specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public TheaterNotFoundException(String msg) {
		super(msg);
	}
}
