package com.example.test.dtos;

import java.util.List;

import com.example.test.modals.UserMaster;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {

	private UserMaster userMaster;
	
	private String message;
	
	private String status;
	
	private List<String> errors ;
	
	private List<UserMaster> users;
	
}
