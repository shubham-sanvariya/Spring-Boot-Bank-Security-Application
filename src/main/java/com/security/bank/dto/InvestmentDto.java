package com.security.bank.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InvestmentDto {

    private String investmentType;

    private double amount;

    private String duration;
}
