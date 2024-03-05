package com.split.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LedgerDto {

    public int ledgerId;
    public String ledgerName;
    public int amount;
    public int userId;
}
