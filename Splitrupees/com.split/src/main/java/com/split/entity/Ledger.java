package com.split.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ledger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int ledgerId;
    public String ledgerName;
    public int amount;
    private int userId;
}
