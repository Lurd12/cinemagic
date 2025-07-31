/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.lur.cinemagic.exception;

/**
 *
 * @author lur
 */
public class InvalidSeatChoiceException extends RuntimeException {

	/**
	 * Creates a new instance of <code>InvalidSeatChoiceException</code>
	 * without detail message.
	 */
	public InvalidSeatChoiceException() {
	}

	/**
	 * Constructs an instance of <code>InvalidSeatChoiceException</code>
	 * with the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public InvalidSeatChoiceException(String msg) {
		super(msg);
	}
}
