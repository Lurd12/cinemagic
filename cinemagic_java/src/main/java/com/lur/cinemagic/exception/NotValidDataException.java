/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.lur.cinemagic.exception;

import org.springframework.validation.BindingResult;

/**
 *
 * @author lur
 */
public class NotValidDataException extends RuntimeException {

	
	private BindingResult bindingResult;

	public NotValidDataException(String message, BindingResult bindingResult) {
		super(message);
		this.bindingResult = bindingResult;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

}
