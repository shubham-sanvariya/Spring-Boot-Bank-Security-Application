package com.security.bank.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Investment {
    private Long id;

    @Enumerated(EnumType.STRING)
    private InvestmentType investmentType;

    private String risk;

    private double amount;

    private float returns;

    private String duration;

    private String companyName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
