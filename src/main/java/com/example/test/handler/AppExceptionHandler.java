package com.example.test.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.test.dtos.ResponseDto;

@ControllerAdvice
public class AppExceptionHandler {

	
	@ExceptionHandler((MethodArgumentNotValidException.class))
	public ResponseEntity<ResponseDto> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception){
	
			List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
			List<String> errors = allErrors.stream().map(objectError ->objectError.getDefaultMessage()).collect(Collectors.toList());
			ResponseDto responseDto = new ResponseDto();
			responseDto.setErrors(errors);
			responseDto.setMessage("something went wrong");
			responseDto.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			return new ResponseEntity<>(responseDto,HttpStatus.BAD_REQUEST);
	}
	
}
