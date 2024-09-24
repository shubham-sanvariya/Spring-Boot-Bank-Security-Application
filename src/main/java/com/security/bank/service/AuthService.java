package com.security.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.bank.dto.JwtRequest;
import com.security.bank.dto.JwtResponse;
import com.security.bank.dto.UserDto;
import com.security.bank.entity.Role;
import com.security.bank.entity.User;
import com.security.bank.jwt.JwtAuthenticationHelper;
import com.security.bank.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private JwtAuthenticationHelper jwtHelper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public JwtResponse login(JwtRequest jwtRequest) {
        String token = jwtHelper.generateToken(jwtRequest);

        return JwtResponse.builder().jwtToken(token).build();
    }

    public void registerUser(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .address(userDto.getAddress())
                .number(userDto.getNumber())
                .identityProof(userDto.getIdentityProof())
                .accountList(userDto.getAccountList())
                .investmentList(userDto.getInvestmentList())
                .build();

        Role role = new Role();
        role.setRoleName("ROLE_CUSTOMER");
        user.setRole(role);
        userRepository.save(user);
    }
}
