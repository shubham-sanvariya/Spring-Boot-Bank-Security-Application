package com.security.bank.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminDto {

    private String name;

    private String username;

    private String password;

    private String address;

    private Long number;

    private String identityProof;
}
