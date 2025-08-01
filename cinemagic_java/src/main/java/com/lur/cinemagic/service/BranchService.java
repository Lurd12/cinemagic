/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.service;

import com.lur.cinemagic.dto.branch.BranchCreateDto;
import com.lur.cinemagic.dto.branch.BranchDetailsDto;
import com.lur.cinemagic.dto.branch.BranchUpdateDto;
import com.lur.cinemagic.exception.BranchNotFoundException;
import com.lur.cinemagic.model.Branch;
import com.lur.cinemagic.repository.BranchRepository;

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
public class BranchService {

	private BranchRepository repository;

	public List<BranchDetailsDto> getAll() {
		List<Branch> branches = repository.findAll();
		List<BranchDetailsDto> branchDetailsDtos = new ArrayList<>();

		for(Branch b: branches){
			branchDetailsDtos.add(BranchDetailsDto.getBranchDetailsDtoFromBranch(b));
		}
		return branchDetailsDtos;
	}

	public BranchDetailsDto getById(Long id) {
		return BranchDetailsDto.getBranchDetailsDtoFromBranch(repository.findById(id)
				.orElseThrow(() -> new BranchNotFoundException("Branch with id=" + id + " not found")));
	}

	public BranchDetailsDto update(BranchUpdateDto branchDto) {
		Branch branch = repository.findById(branchDto.getId())
			.orElseThrow(() -> new BranchNotFoundException("Branch with id=" + branchDto.getId() + " not found"));

		branch.setCountry(branchDto.getCountry());
		branch.setStreet(branchDto.getStreet());
		branch.setExtNumber(branchDto.getExtNumber());
		branch.setState(branchDto.getState());
		branch.setTown(branchDto.getTown());
		return BranchDetailsDto.getBranchDetailsDtoFromBranch(repository.save(branch));
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new BranchNotFoundException("Branch with id=" + id + " not found");
		}
		repository.deleteById(id);
	}

	public BranchDetailsDto insert(BranchCreateDto branchDto) {
		Branch branch = new Branch();
		branch.setCountry(branchDto.getCountry());
		branch.setStreet(branchDto.getStreet());
		branch.setExtNumber(branchDto.getExtNumber());
		branch.setState(branchDto.getState());
		branch.setTown(branchDto.getTown());

		return BranchDetailsDto.getBranchDetailsDtoFromBranch(repository.save(branch));
	}

	public Branch getBranchById(Long id){
		return repository.findById(id)
				.orElseThrow(() -> new BranchNotFoundException("Branch with id=" + id + " not found"));

	}

}
