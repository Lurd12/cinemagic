/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.branch;

import com.lur.cinemagic.model.Branch;

/**
 *
 * @author lur
 */
public class BranchDetailsDto extends BranchUpdateDto{
	
	public static BranchDetailsDto getBranchDetailsDtoFromBranch(Branch branch){
		BranchDetailsDto branchDetailsDto = new BranchDetailsDto();
		branchDetailsDto.setId(branch.getId());
		branchDetailsDto.setCountry(branch.getCountry());
		branchDetailsDto.setStreet(branch.getStreet());
		branchDetailsDto.setExtNumber(branch.getExtNumber());
		branchDetailsDto.setState(branch.getState());
		branchDetailsDto.setTown(branch.getTown());
		
		return  branchDetailsDto;
	}
}
