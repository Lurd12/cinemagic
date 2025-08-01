/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.service;

import com.lur.cinemagic.dto.theater.TheaterCreateDto;
import com.lur.cinemagic.dto.theater.TheaterDetailsDto;
import com.lur.cinemagic.dto.theater.TheaterUpdateDto;
import com.lur.cinemagic.exception.TheaterNotFoundException;
import com.lur.cinemagic.model.Branch;
import com.lur.cinemagic.model.Theater;
import com.lur.cinemagic.repository.TheaterRepository;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author lur
 */
@Service
@AllArgsConstructor
public class TheaterService {
	private TheaterRepository repository;
	private BranchService branchService;
	
	public List<TheaterDetailsDto> getAll(){
		List<Theater> theaters = repository.findAll();
		List<TheaterDetailsDto> theaterDetailsDtos = new ArrayList<>();
		for (Theater t: theaters)
			theaterDetailsDtos.add(TheaterDetailsDto.getTheaterDetailsDtoFromTheater(t));
		return theaterDetailsDtos;
	}
	
	public TheaterDetailsDto getById(Long id){
		Theater t =  repository.findById(id).orElseThrow(() -> new TheaterNotFoundException("Theater with id=" + id + " not found"));
		return TheaterDetailsDto.getTheaterDetailsDtoFromTheater(t);
	}
	
	public TheaterDetailsDto insert(TheaterCreateDto theaterDto){
		Branch branch = branchService.getBranchById(theaterDto.getIdBranch());
		Theater theater = new Theater();
		
		theater.setBranch(branch);
		theater.setName(theaterDto.getName());
		theater.setTotalSeats(theaterDto.getTotalSeats());
		
		return TheaterDetailsDto.getTheaterDetailsDtoFromTheater(repository.save(theater));
	}
	
	public TheaterDetailsDto update(TheaterUpdateDto theaterDto){
		Theater theater = repository.findById(theaterDto.getId()).orElseThrow(() -> new TheaterNotFoundException("Theater with id=" + theaterDto.getId() + " not found"));
		Branch branch = branchService.getBranchById(theaterDto.getIdBranch());

		theater.setName(theaterDto.getName());
		theater.setBranch(branch);
		theater.setTotalSeats(theater.getTotalSeats());
		
		return TheaterDetailsDto.getTheaterDetailsDtoFromTheater(repository.save(theater));
	}
	
	public void deleteById(Long id){
		repository.deleteById(id);
	}

	public Theater getTheaterById(Long id){
		Theater t =  repository.findById(id).orElseThrow(() -> new TheaterNotFoundException("Theater with id=" + id + " not found"));
		return t;
	}
	
	
}
