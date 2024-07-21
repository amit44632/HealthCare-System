package com.infosys.exception;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String,String>ViolationException(ConstraintViolationException ex){
		//  ex.getBindingResult().getAllErrors().forEach((error) -> {
		Map<String,String> errorMap= new HashMap();
		errorMap.put("error_message", ex.getMessage());
		
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(WecareException.class)
	public Map<String,String>coachNotFoundException(WecareException ex){
		Map<String,String> errorMap= new HashMap();
		
		errorMap.put("Error Message", ex.getMessage());
		return errorMap;
		
	}
}
