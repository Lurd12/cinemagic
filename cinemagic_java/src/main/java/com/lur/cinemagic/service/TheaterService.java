/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.service;

import com.lur.cinemagic.dto.theater.TheaterCreateDto;
import com.lur.cinemagic.dto.theater.TheaterUpdateDto;
import com.lur.cinemagic.exception.TheaterNotFoundException;
import com.lur.cinemagic.model.Branch;
import com.lur.cinemagic.model.Theater;
import com.lur.cinemagic.repository.TheaterRepository;
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
	
	public List<Theater> getAll(){
		return repository.findAll();
	}
	
	public Theater getById(Long id){
		return repository.findById(id).orElseThrow(() -> new TheaterNotFoundException("Theater with id=" + id + " not found"));
	}
	
	public Theater insert(TheaterCreateDto theaterDto){
		Branch branch = branchService.getById(theaterDto.getIdBranch());
		Theater theater = new Theater();
		
		theater.setBranch(branch);
		theater.setTotalSeats(theaterDto.getTotalSeats());
		
		return repository.save(theater);
	}
	
	public Theater update(TheaterUpdateDto theaterDto){
		Theater theater = repository.findById(theaterDto.getId()).orElseThrow(() -> new TheaterNotFoundException("Theater with id=" + theaterDto.getId() + " not found"));
		Branch branch = branchService.getById(theaterDto.getIdBranch());
		
		theater.setBranch(branch);
		theater.setTotalSeats(theater.getTotalSeats());
		
		return repository.save(theater);
	}
	
	public void deleteById(Long id){
		repository.deleteById(id);
	}
	
	
}
