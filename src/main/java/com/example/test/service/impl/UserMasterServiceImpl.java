package com.example.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dtos.ResponseDto;
import com.example.test.dtos.UserMasterDto;
import com.example.test.modals.UserMaster;
import com.example.test.repository.IUserMasterRepository;
import com.example.test.service.IUserMasterService;

@Service
public class UserMasterServiceImpl implements IUserMasterService {

	@Autowired
	private IUserMasterRepository repository;
	
	@Override
	public ResponseDto createUser(UserMasterDto createUserDto) {
		
		UserMaster master = new UserMaster();
		BeanUtils.copyProperties(createUserDto, master);
		UserMaster savedUser = repository.save(master);
		
		ResponseDto respone = new ResponseDto();
		respone.setUserMaster(savedUser);
		respone.setMessage("User Created");
		
		return respone;
	}

	@Override
	public ResponseDto getUserById(Long id) {

			Optional<UserMaster> userMasterOptional = repository.findById(id);
			ResponseDto responseDto = new ResponseDto();
			if(userMasterOptional.isPresent()) {
				
				responseDto.setUserMaster(userMasterOptional.get());
				responseDto.setMessage("user found with id :: "+id);
			}else {
				responseDto.setMessage("user not found with id :: "+id);
			}
		return responseDto;
	}

	@Override
	public ResponseDto getAllUser() {
		List<UserMaster> all = repository.findAll();
		ResponseDto responseDto = new ResponseDto();
		responseDto.setUsers(all);
		responseDto.setMessage(all.isEmpty()?"Users not avialable":"Users found");
		return responseDto;
	}

	@Override
	public ResponseDto updateUser(UserMasterDto updateUserDto,Long id) {
		Optional<UserMaster> user = repository.findById(id);
		ResponseDto responseDto = new ResponseDto();
		if(user.isPresent()) {
			UserMaster userMaster = user.get();
			BeanUtils.copyProperties(updateUserDto, userMaster);
			UserMaster updatedUser = repository.save(userMaster);
			responseDto.setUserMaster(updatedUser);
			responseDto.setMessage("User updated with id :: "+id);	
		}else {
			responseDto.setMessage("User not found with id :: "+id);
		}
		return responseDto;
	}

	@Override
	public ResponseDto deleteUserById(Long id) {
		
		Optional<UserMaster> userOptional = repository.findById(id);
		ResponseDto responseDto = new ResponseDto();
		try {
			if(userOptional.isPresent()) {
				UserMaster userMaster = userOptional.get();
				repository.delete(userMaster);
				responseDto.setMessage("user deleted with id :: "+id);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
			responseDto.setMessage("user not found with id :: "+id);
			
		}
		return responseDto;
	}

}
