/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.lur.cinemagic.exception;

/**
 *
 * @author lur
 */
public class ShowFullOfPeopleException extends RuntimeException {

	/**
	 * Creates a new instance of <code>ShowFullOfPeopleException</code>
	 * without detail message.
	 */
	public ShowFullOfPeopleException() {
	}

	/**
	 * Constructs an instance of <code>ShowFullOfPeopleException</code> with
	 * the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public ShowFullOfPeopleException(String msg) {
		super(msg);
	}
}
