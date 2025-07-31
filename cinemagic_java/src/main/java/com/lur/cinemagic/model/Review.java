/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lur
 */
@Entity
@Getter
@Setter
public class Review {
  @Id
  @Column(name = "id_review")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int calification;

  private String content;

  private LocalDate date;

  @ManyToOne
  @JoinColumn(name = "id_movie")
  private Movie movie;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private CinemaUser user;

}
