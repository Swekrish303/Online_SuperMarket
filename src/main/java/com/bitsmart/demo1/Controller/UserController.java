package com.bitsmart.demo1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitsmart.demo1.dto.ResponseDto;
import com.bitsmart.demo1.service.UserService;

@RequestMapping("user")
@RestController
public class UserController {
	@Autowired
    UserService userService;

    

    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto) {
        return userService.signUp(signupDto);
    }


    // signin

    @PostMapping("/signin")
    public SignInReponseDto signIn(@RequestBody SignInDto signInDto) {
        return userService.signIn(signInDto);
    }
}
