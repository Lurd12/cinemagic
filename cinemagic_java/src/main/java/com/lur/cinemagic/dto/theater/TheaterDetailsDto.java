/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.theater;

import com.lur.cinemagic.dto.branch.BranchDetailsDto;
import com.lur.cinemagic.model.Theater;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lur
 */
@Getter
@Setter
public class TheaterDetailsDto {

  private Long id;
  private int totalSeats;
  private String name;
  private BranchDetailsDto branchDto;

  public static TheaterDetailsDto getTheaterDetailsDtoFromTheater(Theater theater) {
    TheaterDetailsDto theaterDetailsDto = new TheaterDetailsDto();
    theaterDetailsDto.setBranchDto(BranchDetailsDto.getBranchDetailsDtoFromBranch(theater.getBranch()));
    theaterDetailsDto.setId(theater.getId());
    theaterDetailsDto.setName(theater.getName());
    theaterDetailsDto.setTotalSeats(theater.getTotalSeats());

    return theaterDetailsDto;
  }
}
