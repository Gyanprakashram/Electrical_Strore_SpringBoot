package com.wipro.electricalstore.exceptionHandling;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController 
{
	  @ExceptionHandler(AccountNotFoundException.class)
	    public  ResponseEntity<String> handleAccountNotFoundException(AccountNotFoundException ex) {
	        return new ResponseEntity<>("Not found: " + ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	  
	  @ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleAllExceptions(Exception ex) {
	        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	 
 

}
