/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.lur.cinemagic.exception;

/**
 *
 * @author lur
 */
public class MovieReviewFromCurrentUserAlreadyExists extends RuntimeException {

	/**
	 * Creates a new instance of
	 * <code>MovieReviewFromCurrentUserAlreadyExists</code> without detail
	 * message.
	 */
	public MovieReviewFromCurrentUserAlreadyExists() {
	}

	/**
	 * Constructs an instance of
	 * <code>MovieReviewFromCurrentUserAlreadyExists</code> with the
	 * specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public MovieReviewFromCurrentUserAlreadyExists(String msg) {
		super(msg);
	}
}
