package com.bitsmart.demo1.exceptions;

public class AuthenticationFailException extends IllegalArgumentException {
    public AuthenticationFailException(String msg){
        super(msg);
    }

}
