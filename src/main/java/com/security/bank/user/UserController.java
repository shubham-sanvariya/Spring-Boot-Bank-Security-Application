package com.security.bank.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.bank.dto.UserDto;
import com.security.bank.service.AuthService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public void registerUser(UserDto userDto){
        authService.registerUser(userDto);
    }
}
