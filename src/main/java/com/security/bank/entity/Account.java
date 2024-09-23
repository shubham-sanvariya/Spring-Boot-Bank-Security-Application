package com.security.bank.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private String status;

    private double balance;

    private float interestRate;

    @Enumerated(EnumType.STRING)
    private BranchType branch;

    private String proof;

    private Date openingDate;

    private Long accountNumber;

    @OneToOne
    private Nominee nominee;

    @OneToOne
    private Card card;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
