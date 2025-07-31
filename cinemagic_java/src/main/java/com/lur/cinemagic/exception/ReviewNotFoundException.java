/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license Click
 * nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this
 * template
 */
package com.lur.cinemagic.exception;

/**
 *
 * @author lur
 */
public class ReviewNotFoundException extends RuntimeException {

  /**
   * Creates a new instance of <code>ReviewNotFoundException</code>
   * without detail message.
   */
  public ReviewNotFoundException() {}

  /**
   * Constructs an instance of <code>ReviewNotFoundException</code> with
   * the specified detail message.
   *
   * @param msg the detail message.
   */
  public ReviewNotFoundException(String msg) { super(msg); }
}
