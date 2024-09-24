package com.security.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.bank.dto.JwtRequest;
import com.security.bank.dto.JwtResponse;
import com.security.bank.jwt.JwtAuthenticationHelper;

@Service
public class AuthService {

    @Autowired
    private JwtAuthenticationHelper jwtHelper;

    public JwtResponse login(JwtRequest jwtRequest){
        String token = jwtHelper.generateToken(jwtRequest);
        
        return JwtResponse.builder().jwtToken(token).build();
    }
}
