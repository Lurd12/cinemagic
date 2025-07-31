/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.controller;

import com.lur.cinemagic.dto.theater.TheaterCreateDto;
import com.lur.cinemagic.dto.theater.TheaterUpdateDto;
import com.lur.cinemagic.model.Theater;
import com.lur.cinemagic.service.TheaterService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lur 
 *
 * */
@RestController
@RequestMapping("cinemagic/theater")
@AllArgsConstructor
public class TheaterController {
  private TheaterService service;

  // ENDPOINTS ALLOWED FOR ANYONE

  @GetMapping
  public ResponseEntity<List<Theater>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Theater> getById(@PathVariable Long id) {
    return ResponseEntity.ok(service.getById(id));
  }

  // ENDPOINTS ALLOWED FOR ADMINS

  @PostMapping
  public ResponseEntity<Theater> insert(@RequestBody TheaterCreateDto theaterDto) {
    return ResponseEntity.ok(service.insert(theaterDto));
  }

  @PutMapping
  public ResponseEntity<Theater> update(@RequestBody TheaterUpdateDto theaterDto) {
    return ResponseEntity.ok(service.update(theaterDto));
  }

  @DeleteMapping("/{id}")
  private ResponseEntity<?> delete(@PathVariable Long id) {
    service.deleteById(id);
    return ResponseEntity.ok().build();
  }

}
