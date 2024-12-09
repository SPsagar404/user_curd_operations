package com.example.test.dtos;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Validated
public class UserMasterDto {
	
	@NotNull(message = "Name should not be null...")
	private String name;
	
	@NotNull(message = "Email should not be null...")
	private String email;
	
	@NotNull(message = "Password should not be null...")
	private String password;

}
