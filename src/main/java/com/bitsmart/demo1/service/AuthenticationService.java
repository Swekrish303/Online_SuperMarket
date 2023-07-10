package com.bitsmart.demo1.service;

	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.bitsmart.demo1.Repository.TokenRepo;
import com.bitsmart.demo1.exceptions.AuthenticationFailException;
import com.bitsmart.demo1.model.AuthenticationToken;
import com.bitsmart.demo1.model.User;

import java.util.Objects;

	@Service
	public class AuthenticationService {

	    @Autowired
	    TokenRepo tokenRepo;

	    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
	        tokenRepo.save(authenticationToken);
	    }

	    public AuthenticationToken getToken(User user) {
	        return tokenRepo.findByUser(user);
	    }


	    public static User getUser(String token) {
	        final AuthenticationToken authenticationToken = tokenRepo.findByToken(token);
	        if(Objects.isNull(authenticationToken)) {
	            return null;
	        }
	        // authenticationToken is not null
	        return authenticationToken.getUser();
	    }

	    public void authenticate(String token) throws AuthenticationFailException {
	        // null check
	        if(Objects.isNull(token)) {
	            // throw an exception
	            throw new AuthenticationFailException("token not present");
	        }
	        if(Objects.isNull(getUser(token))) {
	            throw new AuthenticationFailException("token not valid");
	        }
	    }
}
