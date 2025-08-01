/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license Click
 * nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this
 * template
 */
package com.lur.cinemagic.controller;

import com.lur.cinemagic.dto.branch.BranchCreateDto;
import com.lur.cinemagic.dto.branch.BranchDetailsDto;
import com.lur.cinemagic.dto.branch.BranchUpdateDto;
import com.lur.cinemagic.exception.NotValidDataException;
import com.lur.cinemagic.model.Branch;
import com.lur.cinemagic.service.BranchService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
 */
@RestController
@RequestMapping("cinemagic/branch")
@AllArgsConstructor
public class BranchController {

	private BranchService service;

	// ENDPOINTS ALLOWED FOR EVERYONE
	@GetMapping
	public ResponseEntity<List<BranchDetailsDto>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<BranchDetailsDto> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	// ENDPOINTS ONLY ALLOWED FOR ADMINS
	@PostMapping
	public ResponseEntity<BranchDetailsDto> insert(@Valid @RequestBody BranchCreateDto branch, BindingResult bindigResult) {
		if (bindigResult.hasErrors()) {
			throw new NotValidDataException("Validation error", bindigResult);
			
		}
		return ResponseEntity.ok(service.insert(branch));
	}

	@PutMapping
	public ResponseEntity<BranchDetailsDto> update(@Valid @RequestBody BranchUpdateDto branch, BindingResult bindigResult) {
		if (bindigResult.hasErrors()) {
			throw new NotValidDataException("Validation error", bindigResult);
			
		}
		return ResponseEntity.ok(service.update(branch));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
