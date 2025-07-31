/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.service;

import com.lur.cinemagic.dto.branch.BranchCreateDto;
import com.lur.cinemagic.dto.branch.BranchUpdateDto;
import com.lur.cinemagic.exception.BranchNotFoundException;
import com.lur.cinemagic.model.Branch;
import com.lur.cinemagic.repository.BranchRepository;
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

	public List<Branch> getAll() {
		return repository.findAll();
	}

	public Branch getById(Long id) {
		return repository.findById(id)
			.orElseThrow(() -> new BranchNotFoundException("Branch with id=" + id + " not found"));
	}

	public Branch update(BranchUpdateDto branchDto) {
		Branch branch = repository.findById(branchDto.getId())
			.orElseThrow(() -> new BranchNotFoundException("Branch with id=" + branchDto.getId() + " not found"));

		branch.setCountry(branchDto.getCountry());
		branch.setStreet(branchDto.getStreet());
		branch.setExtNumber(branchDto.getExtNumber());
		branch.setState(branchDto.getState());
		branch.setTown(branchDto.getTown());
		return repository.save(branch);
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new BranchNotFoundException("Branch with id=" + id + " not found");
		}
		repository.deleteById(id);
	}

	public Branch insert(BranchCreateDto branchDto) {
		Branch branch = new Branch();
		branch.setCountry(branchDto.getCountry());
		branch.setStreet(branchDto.getStreet());
		branch.setExtNumber(branchDto.getExtNumber());
		branch.setState(branchDto.getState());
		branch.setTown(branchDto.getTown());

		return repository.save(branch);
	}

}
