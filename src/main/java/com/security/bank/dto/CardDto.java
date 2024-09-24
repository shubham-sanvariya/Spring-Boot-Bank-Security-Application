package com.security.bank.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CardDto {

    private String cardHolderName;

    private String cardType;

    private Long pin;
}
