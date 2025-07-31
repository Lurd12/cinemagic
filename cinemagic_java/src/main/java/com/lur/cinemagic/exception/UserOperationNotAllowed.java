/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.lur.cinemagic.exception;

/**
 *
 * @author lur
 */
public class UserOperationNotAllowed extends RuntimeException{

	/**
	 * Creates a new instance of <code>UserOperationNotAllowed</code>
	 * without detail message.
	 */
	public UserOperationNotAllowed() {
	}

	/**
	 * Constructs an instance of <code>UserOperationNotAllowed</code> with
	 * the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public UserOperationNotAllowed(String msg) {
		super(msg);
	}
}
