package com.bhavna.Exception;

import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling  {
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handle1(NullPointerException msg){
		return new ResponseEntity<String>(msg.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handle2(EmptyResultDataAccessException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handle3(EntityNotFoundException q){
		return new ResponseEntity<String>(q.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handle4(NoSuchElementException  f){
		return new ResponseEntity<String>(f.getMessage(),HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handle4(Exception  k){
		return new ResponseEntity<String>(k.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
