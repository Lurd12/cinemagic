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
public class BranchNotFoundException extends RuntimeException {

  /**
   * Creates a new instance of <code>BrachNotFoundException</code> without
   * detail message.
   */
  public BranchNotFoundException() {}

  /**
   * Constructs an instance of <code>BrachNotFoundException</code> with
   * the specified detail message.
   *
   * @param msg the detail message.
   */
  public BranchNotFoundException(String msg) { super(msg); }
}
