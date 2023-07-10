package com.bitsmart.demo1.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class Walletexception extends RuntimeException{
    public Walletexception(String message) { super(message);}
}