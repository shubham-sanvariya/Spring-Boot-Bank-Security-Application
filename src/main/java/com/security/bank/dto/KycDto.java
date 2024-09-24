package com.security.bank.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KycDto {

    private String name;

    private String address;

    private Long number;

    private String identityProof;
}
