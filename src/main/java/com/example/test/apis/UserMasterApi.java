package com.example.test.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.dtos.ResponseDto;
import com.example.test.dtos.UserMasterDto;
import com.example.test.service.IUserMasterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserMasterApi {

	@Autowired
	private IUserMasterService service;

	@PostMapping
	public ResponseEntity<ResponseDto> saveUser(@Valid @RequestBody UserMasterDto dto) {

		ResponseDto response = service.createUser(dto);
		response.setStatus(HttpStatus.CREATED.getReasonPhrase());
		return new ResponseEntity<ResponseDto>(response, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDto> getUserById(@PathVariable Long id) {

		ResponseDto response = service.getUserById(id);
		response.setStatus(HttpStatus.OK.getReasonPhrase());
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ResponseDto> getUsers() {

		ResponseDto response = service.getAllUser();
		response.setStatus(HttpStatus.OK.getReasonPhrase());
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseDto> updateUser(@Valid @RequestBody UserMasterDto user, @PathVariable Long id) {

		ResponseDto response = service.updateUser(user, id);
		response.setStatus(HttpStatus.OK.getReasonPhrase());
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDto> deleteUserById(@PathVariable Long id) {

		ResponseDto response = service.deleteUserById(id);
		response.setStatus(HttpStatus.OK.getReasonPhrase());
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

}
