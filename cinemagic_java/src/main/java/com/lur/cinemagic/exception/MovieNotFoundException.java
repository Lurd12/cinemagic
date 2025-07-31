/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.lur.cinemagic.exception;

/**
 *
 * @author lur
 */
public class MovieNotFoundException extends RuntimeException {

	/**
	 * Creates a new instance of <code>MovieNotFoundException</code> without
	 * detail message.
	 */
	public MovieNotFoundException() {
	}

	/**
	 * Constructs an instance of <code>MovieNotFoundException</code> with
	 * the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public MovieNotFoundException(String msg) {
		super(msg);
	}
}
