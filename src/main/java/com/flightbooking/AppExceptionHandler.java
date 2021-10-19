package com.flightbooking;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value= {IllegalArgumentException.class,EntityNotFoundException.class})
	public ResponseEntity<Object>IAExceptionHandler(Exception ex,WebRequest request)
	{
		String msg="Error in Operation"+ex.getMessage();
		return handleExceptionInternal(ex,msg,new HttpHeaders(),
				HttpStatus.CONFLICT,request);
	}
	//CUSTOM HANDLING EXCEPTION
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers,WebRequest request)
	{
		List<String>errorList=ex.getBindingResult().getAllErrors().stream()
				.map(fieldError->fieldError.getDefaultMessage())
				.collect(Collectors.toList());
		System.out.println("In Exception...."+errorList);
		return handleExceptionInternal(ex,errorList,headers,HttpStatus.BAD_REQUEST,request);
		
	}
}

