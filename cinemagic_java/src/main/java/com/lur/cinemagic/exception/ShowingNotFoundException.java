/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.lur.cinemagic.exception;

/**
 *
 * @author lur
 */
public class ShowingNotFoundException extends RuntimeException {

	/**
	 * Creates a new instance of <code>ShowingNotFoundException</code>
	 * without detail message.
	 */
	public ShowingNotFoundException() {
	}

	/**
	 * Constructs an instance of <code>ShowingNotFoundException</code> with
	 * the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public ShowingNotFoundException(String msg) {
		super(msg);
	}
}
