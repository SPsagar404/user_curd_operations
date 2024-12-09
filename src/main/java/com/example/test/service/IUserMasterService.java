package com.example.test.service;

import com.example.test.dtos.ResponseDto;
import com.example.test.dtos.UserMasterDto;

public interface IUserMasterService {

	public ResponseDto createUser(UserMasterDto createUserDto);
	
	public ResponseDto getUserById(Long id);
	
	public ResponseDto getAllUser();
	
	public ResponseDto updateUser(UserMasterDto updateUserDto,Long id);
	
	public ResponseDto deleteUserById(Long id);
	
}
