/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lur.cinemagic.dto.branch;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import javax.management.MXBean;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lur
 */
@Getter
@Setter
public class BranchUpdateDto extends BranchCreateDto{
	@NotNull(message = "Id must not be null")
	@Min(value = 1, message="Id must not be < 1")
	private Long id;
}
