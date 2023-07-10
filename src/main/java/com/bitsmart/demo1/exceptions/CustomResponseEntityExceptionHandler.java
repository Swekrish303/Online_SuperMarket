package com.bitsmart.demo1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;


@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler {
	  @ExceptionHandler
	    public final ResponseEntity<?> handleWalletException(Walletexception ex, WebRequest request){
		  WalletexceptionResponse response = new WalletexceptionResponse();
	        return new ResponseEntity<WalletexceptionResponse>(response, HttpStatus.BAD_REQUEST);
	    }
}
